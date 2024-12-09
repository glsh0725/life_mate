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
import java.util.*;

@Service
public class MateServiceImpl implements MateService {

    // 유아 동반 API URL
    private static final String INFANT_API_URL = "https://api.odcloud.kr/api/15111391/v1/uddi:19c0c9ab-ac89-486b-b4b8-b026506dc3fa";
    // 반려동물 API URL
    private static final String PET_API_URL = "https://api.odcloud.kr/api/15111389/v1/uddi:41944402-8249-4e45-9e9d-a52d0a7db1cc";
    // 서비스키
    private static final String SERVICE_KEY = "9E5LkDla3NtpffFe9%2BgzMow%2FMoH2X%2B5xQNVxuvQwz5uvf3KsPlXqUX40L%2FK9wbDbDKJVGQLIJZkhKKGHC%2Fzrgg%3D%3D";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @Cacheable(value = "mateData", key = "'infantData'")
    public List<MateVO> getInfantData() {
        return fetchPagedData(INFANT_API_URL, true);
    }

    @Override
    @Cacheable(value = "mateData", key = "'petData'")
    public List<MateVO> getPetData() {
        return fetchPagedData(PET_API_URL, false);
    }

    @Override
    @Cacheable(value = "mateData", key = "'combinedData'")
    public List<MateVO> getCombinedData() {
        List<MateVO> infantData = getInfantData();
        List<MateVO> petData = getPetData();
        List<MateVO> combinedData = new ArrayList<>();

        Map<String, MateVO> petDataMap = new HashMap<>();
        for (MateVO pet : petData) {
            petDataMap.put(pet.getFacilityName(), pet);
        }

        for (MateVO infant : infantData) {
            MateVO matchingPet = petDataMap.get(infant.getFacilityName());
            if (matchingPet != null) {
                MateVO combinedMate = mergeMateData(infant, matchingPet);
                combinedData.add(combinedMate);
            }
        }

        return combinedData;
    }

    private MateVO mergeMateData(MateVO infant, MateVO pet) {
        MateVO combined = new MateVO();

        combined.setFacilityName(infant.getFacilityName());
        combined.setContact(infant.getContact());
        combined.setOldAddress(infant.getOldAddress());
        combined.setNewAddress(infant.getNewAddress());
        combined.setUrl(infant.getUrl());
        combined.setBusinessHours(infant.getBusinessHours());
        combined.setHoliday(infant.getHoliday());
        combined.setLastUpdated(infant.getLastUpdated());
        combined.setCity(infant.getCity());
        combined.setCityDistrict(infant.getCityDistrict());

        combined.setBlogUrl(infant.getBlogUrl());
        combined.setFacebookUrl(infant.getFacebookUrl());
        combined.setInstargramUrl(infant.getInstargramUrl());
        combined.setEntryFee(infant.getEntryFee());
        combined.setFreeParking(infant.getFreeParking());
        combined.setPaidParking(infant.getPaidParking());
        combined.setEntryAge(infant.getEntryAge());
        combined.setFamilyToilet(infant.getFamilyToilet());
        combined.setStrollerRental(infant.getStrollerRental());
        combined.setNursingRoom(infant.getNursingRoom());
        combined.setKidZone(infant.getKidZone());

        combined.setPetCompanionFee(pet.getPetCompanionFee());
        combined.setPetRestrictions(pet.getPetRestrictions());
        combined.setParking(pet.getParking());
        combined.setIndoor(pet.getIndoor());
        combined.setOutdoor(pet.getOutdoor());
        combined.setPetSize(pet.getPetSize());
        combined.setPetFriendly(pet.getPetFriendly());

        return combined;
    }

    @Cacheable(value = "mateData", key = "#apiUrl")
    private List<MateVO> fetchPagedData(String apiUrl, boolean isInfantData) {
        List<MateVO> mateList = new ArrayList<>();
        int page = 1;

        while (true) {
            try {
                String fullUrl = String.format("%s?page=%d&perPage=500&returnType=json&serviceKey=%s", apiUrl, page, SERVICE_KEY);
                String response = getApiResponse(fullUrl);
                if (response == null) break;

                JsonNode dataNode = objectMapper.readTree(response).path("data");
                if (dataNode.isArray() && dataNode.size() > 0) {
                    for (JsonNode node : dataNode) {
                        MateVO mate = mapJsonToMateVO(node, isInfantData);
                        if (isInfantData || mate.getPetFriendly() == 'Y') {
                            mateList.add(mate);
                        }
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

    private MateVO mapJsonToMateVO(JsonNode node, boolean isInfantData) {
        MateVO mate = new MateVO();

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

        if (isInfantData) {
            mate.setBlogUrl(node.path("블로그 주소").asText(""));
            mate.setFacebookUrl(node.path("페이스북 주소").asText(""));
            mate.setInstargramUrl(node.path("인스타 주소").asText(""));
            mate.setEntryFee(node.path("입장료 유무 여부").asText("").isEmpty() ? 'N' : node.path("입장료 유무 여부").asText().charAt(0));
            mate.setFreeParking(node.path("무료주차 가능여부").asText("").isEmpty() ? 'N' : node.path("무료주차 가능여부").asText().charAt(0));
            mate.setPaidParking(node.path("유료주차 가능여부").asText("").isEmpty() ? 'N' : node.path("유료주차 가능여부").asText().charAt(0));
            mate.setEntryAge(node.path("입장 가능 나이").asText(""));
            mate.setFamilyToilet(node.path("가족 화장실 보유 여부").asText("").isEmpty() ? 'N' : node.path("가족 화장실 보유 여부").asText().charAt(0));
            mate.setStrollerRental(node.path("유모차 대여 여부").asText("").isEmpty() ? 'N' : node.path("유모차 대여 여부").asText().charAt(0));
            mate.setNursingRoom(node.path("수유실 보유 여부").asText("").isEmpty() ? 'N' : node.path("수유실 보유 여부").asText().charAt(0));
            mate.setKidZone(node.path("키즈존 여부").asText("").isEmpty() ? 'N' : node.path("키즈존 여부").asText().charAt(0));
        } else {
            mate.setPetCompanionFee(node.path("애견 동반 추가 요금").asText(""));
            mate.setPetRestrictions(node.path("반려동물 제한사항").asText(""));
            mate.setParking(node.path("주차 가능여부").asText("").isEmpty() ? 'N' : node.path("주차 가능여부").asText().charAt(0));
            mate.setIndoor(node.path("장소(실내) 여부").asText("").isEmpty() ? 'N' : node.path("장소(실내) 여부").asText().charAt(0));
            mate.setOutdoor(node.path("장소(실외)여부").asText("").isEmpty() ? 'N' : node.path("장소(실외)여부").asText().charAt(0));
            mate.setPetSize(node.path("입장 가능 동물 크기").asText(""));
            mate.setPetFriendly(node.path("반려동물 동반 가능정보").asText("").isEmpty() ? 'N' : node.path("반려동물 동반 가능정보").asText().charAt(0));
        }

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