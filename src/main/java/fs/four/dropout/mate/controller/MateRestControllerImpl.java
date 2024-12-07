package fs.four.dropout.mate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@RestController
public class MateRestControllerImpl {

    // 오픈 Api
    @GetMapping("/mateapi")
    public String mateapilist() {

        StringBuilder result = new StringBuilder();
        try {
            String apiUrl = "https://api.odcloud.kr/api/15111391/v1/uddi:19c0c9ab-ac89-486b-b4b8-b026506dc3fa?" +
                    "serviceKey=2hC0NOczqdO6hmbRzTAjPIB%2FyONZvVG2Esgsbr2a3J2nkIDwjAimqU4QHeZLGfldA%2BuMYVh731h6uAc715ss5A%3D%3D" +
                    "&page=1" +
                    "&perPage=10" +
                    "&returnType=json";

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));

            String returnLine;
            while ((returnLine = bufferedReader.readLine()) != null){
                result.append(returnLine).append("\n");
            }

            // 연결 끊어주기
            urlConnection.disconnect();

        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

        return result.toString();
    }
}
