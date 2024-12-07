package fs.four.dropout.mate.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fs.four.dropout.mate.vo.MateVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("mateServiceImpl")
public class MateServiceImpl implements MateService {

    private static final String BASE_API_URL = "http://https://api.odcloud.kr/api/15111391/v1/uddi:19c0c9ab-ac89-486b-b4b8-b026506dc3fa?"
            + "serviceKey=2hC0NOczqdO6hmbRzTAjPIB%2FyONZvVG2Esgsbr2a3J2nkIDwjAimqU4QHeZLGfldA%2BuMYVh731h6uAc715ss5A%3D%3D"
            + "page=1&perPage=10&returnType=json";

    @Override
    public List<MateVO> selectAllMateList() {
        List<MateVO> allMateList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        int pageNo = 1;

        return allMateList;
    }
}
