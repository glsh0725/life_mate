package fs.four.dropout.mate.controller;

import fs.four.dropout.mate.service.MateService;
import fs.four.dropout.mate.vo.MateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MateControllerImpl {

    @Autowired
    private MateService mateService;

    // 메인 페이지
    @GetMapping("/mate")
    public String mainPage() {
        return "mate/mate";
    }

    // 유아 동반 데이터
    @GetMapping("/api/mate/infants")
    @ResponseBody
    public List<MateVO> getInfantData() {
        return mateService.getInfantData();
    }

    // 반려동물 동반 데이터
    @GetMapping("/api/mate/pets")
    @ResponseBody
    public List<MateVO> getPetData() {
        return mateService.getPetData();
    }

    // 유아 및 반려동물 데이터
    @GetMapping("/api/mate/combined")
    @ResponseBody
    public List<MateVO> getCombinedData() {
        return mateService.getCombinedData();
    }
}