package fs.four.dropout.mate.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fs.four.dropout.mate.vo.MateVO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MateServiceImpl implements MateService {

    // 유아 동반 API URL
    private static final String INFANT_API_URL = "https://api.odcloud.kr/api/15111391/v1/uddi:19c0c9ab-ac89-486b-b4b8-b026506dc3fa";
    // 반려동물 API URL (반려동물 API 주소가 나중에 제공되면 여기에 적용)
    private static final String PET_API_URL = "https://example.com/pet-api"; // 예시로 제공된 URL, 실제 반려동물 API URL로 변경 필요
    private static final String SERVICE_KEY = "9E5LkDla3NtpffFe9%2BgzMow%2FMoH2X%2B5xQNVxuvQwz5uvf3KsPlXqUX40L%2FK9wbDbDKJVGQLIJZkhKKGHC%2Fzrgg%3D%3D";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<MateVO> getInfantData() {
        return fetchPagedData(INFANT_API_URL); // 유아 동반 API 데이터
    }

    @Override
    public List<MateVO> getPetData() {
        return fetchPagedData(PET_API_URL); // 반려동물 동반 API 데이터
    }

    @Override
    public List<MateVO> getCombinedData() {
        List<MateVO> combinedData = new ArrayList<>();
        combinedData.addAll(getInfantData());
        combinedData.addAll(getPetData());
        return combinedData;
    }

    @Cacheable(value = "mateData", key = "'pagedData'")
    private List<MateVO> fetchPagedData(String apiUrl) {
        List<MateVO> mateList = new ArrayList<>();
        int page = 1;

        while (page == 1) {
            try {
                String fullUrl = String.format("%s?page=%d&perPage=10&returnType=json&serviceKey=%s", apiUrl, page, SERVICE_KEY);
                String response = getApiResponse(fullUrl);
                if (response == null) break;

                JsonNode dataNode = objectMapper.readTree(response).path("data");
                if (dataNode.isArray() && dataNode.size() > 0) {
                    for (JsonNode node : dataNode) {
                        MateVO mate = mapJsonToMateVO(node);
                        mateList.add(mate);
                    }
                    page++;
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

        return mateList;
    }

    private MateVO mapJsonToMateVO(JsonNode node) {
        MateVO mate = new MateVO();

        // 공통 필드
        mate.setFacilityName(node.path("시설명").asText(""));
        mate.setContact(node.path("전화번호").asText(""));
        mate.setOldAddress(node.path("지번주소").asText(""));
        mate.setNewAddress(node.path("도로명주소").asText(""));
        mate.setUrl(node.path("홈페이지").asText(""));
        mate.setBusinessHours(node.path("운영시간").asText(""));
        mate.setHoliday(node.path("휴무일").asText(""));
        String lastUpdatedStr = node.path("최종작성일").asText("");

        if (!lastUpdatedStr.isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate lastUpdated = LocalDate.parse(lastUpdatedStr, formatter);
                mate.setLastUpdated(java.sql.Date.valueOf(lastUpdated));
            } catch (Exception e) {
                e.printStackTrace();
                mate.setLastUpdated(null);
            }
        }

        mate.setCity(node.path("시도 명칭").asText(""));
        mate.setCityDistrict(node.path("시군구 명칭").asText(""));

        // 유아 동반 관련 필드
        mate.setBlogUrl(node.path("블로그 주소").asText(""));
        mate.setFacebookUrl(node.path("페이스북 주소").asText(""));
        mate.setInstargramUrl(node.path("인스타 주소").asText(""));

        String entryFee = node.path("입장료 유무 여부").asText("");
        mate.setEntryFee(entryFee.isEmpty() ? 'N' : entryFee.charAt(0));

        String freeParking = node.path("무료주차 가능여부").asText("");
        mate.setFreeParking(freeParking.isEmpty() ? 'N' : freeParking.charAt(0));

        String paidParking = node.path("유료주차 가능여부").asText("");
        mate.setPaidParking(paidParking.isEmpty() ? 'N' : paidParking.charAt(0));

        mate.setEntryAge(node.path("입장 가능 나이").asText(""));

        String familyToilet = node.path("가족 화장실 보유 여부").asText("");
        mate.setFamilyToilet(familyToilet.isEmpty() ? 'N' : familyToilet.charAt(0));

        String strollerRental = node.path("유모차 대여 여부").asText("");
        mate.setStrollerRental(strollerRental.isEmpty() ? 'N' : strollerRental.charAt(0));

        String nursingRoom = node.path("수유실 보유 여부").asText("");
        mate.setNursingRoom(nursingRoom.isEmpty() ? 'N' : nursingRoom.charAt(0));

        String kidZone = node.path("키즈존 여부").asText("");
        mate.setKidZone(kidZone.isEmpty() ? 'N' : kidZone.charAt(0));

        return mate;
    }

    private String getApiResponse(String apiUrl) {
        StringBuilder response = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return response.toString();
    }
}