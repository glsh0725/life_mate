package fs.four.dropout.festival.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fs.four.dropout.festival.vo.FestivalVO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FestivalServiceImpl implements FestivalService {

    private static final String BASE_API_URL = "http://api.data.go.kr/openapi/tn_pubr_public_cltur_fstvl_api"
            + "?serviceKey=9E5LkDla3NtpffFe9%2BgzMow%2FMoH2X%2B5xQNVxuvQwz5uvf3KsPlXqUX40L%2FK9wbDbDKJVGQLIJZkhKKGHC%2Fzrgg%3D%3D"
            + "&numOfRows=100&type=json";

    @Override
    @Cacheable(value = "festivals", key = "'allFestivals'")
    public List<FestivalVO> getAllFestivals() {
        List<FestivalVO> allFestivals = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        int pageNo = 1;

        Set<String> uniqueFestivalNames = new HashSet<>();

        try {
            while (true) {
                String response = getApiResponse(BASE_API_URL + "&pageNo=" + pageNo);
                if (response == null) break;

                JsonNode itemsNode = objectMapper.readTree(response)
                        .path("response")
                        .path("body")
                        .path("items");

                if (itemsNode.isArray() && itemsNode.size() > 0) {
                    for (JsonNode item : itemsNode) {
                        FestivalVO festival = objectMapper.treeToValue(item, FestivalVO.class);

                        if (uniqueFestivalNames.contains(festival.getFstvlNm())) {
                            continue;
                        }
                        uniqueFestivalNames.add(festival.getFstvlNm());

                        String address = item.path("rdnmadr").asText();
                        if (address.isEmpty()) {
                            address = item.path("lnmadr").asText();
                        }
                        if (!address.isEmpty()) {
                            String[] words = address.split(" ");
                            if (words.length > 1) {
                                address = words[0] + " " + words[1];
                            }
                        }
                        festival.setAddress(address);
                        allFestivals.add(festival);
                    }
                    pageNo++;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allFestivals;
    }

    @Override
    @Cacheable(value = "festivals", key = "'page_' + #page + '_size_' + #pageSize")
    public List<FestivalVO> getFestivalsByPage(int page, int pageSize) {
        List<FestivalVO> allFestivals = getAllFestivals();
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, allFestivals.size());
        if (fromIndex >= allFestivals.size()) {
            return new ArrayList<>();
        }
        return allFestivals.subList(fromIndex, toIndex);
    }

    @Override
    @Cacheable(value = "festivals", key = "'date_' + #date")
    public List<FestivalVO> getFestivalsByDate(String date) {
        List<FestivalVO> filteredFestivals = new ArrayList<>();
        try {
            List<FestivalVO> allFestivals = getAllFestivals();

            for (FestivalVO festival : allFestivals) {
                String startDate = festival.getFstvlStartDate();
                String endDate = festival.getFstvlEndDate();

                if (isDateInRange(date, startDate, endDate)) {
                    filteredFestivals.add(festival);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredFestivals;
    }

    @Override
    @Cacheable(value = "festivals", key = "'date_' + #date + '_address_' + #address")
    public List<FestivalVO> getFestivalsByDateAndAddress(String date, String address) {
        List<FestivalVO> filteredFestivals = new ArrayList<>();
        try {
            List<FestivalVO> allFestivals = getAllFestivals();

            for (FestivalVO festival : allFestivals) {
                String startDate = festival.getFstvlStartDate();
                String endDate = festival.getFstvlEndDate();
                String festivalAddress = festival.getAddress();

                if (isDateInRange(date, startDate, endDate) && festivalAddress.contains(address)) {
                    filteredFestivals.add(festival);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredFestivals;
    }

    private boolean isDateInRange(String date, String startDate, String endDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date selectedDate = sdf.parse(date);
            Date festivalStartDate = sdf.parse(startDate);
            Date festivalEndDate = sdf.parse(endDate);

            return !selectedDate.before(festivalStartDate) && !selectedDate.after(festivalEndDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getApiResponse(String apiUrl) {
        StringBuilder response = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = in.readLine()) != null) {
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