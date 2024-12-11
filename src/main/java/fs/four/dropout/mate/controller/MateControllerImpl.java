package fs.four.dropout.mate.controller;

import fs.four.dropout.mate.service.MateService;
import fs.four.dropout.mate.vo.MateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MateControllerImpl implements MateController {

    @Autowired
    private MateService mateService;

    // Mate 데이터를 조회하여 JSP로 전달
    @GetMapping("/mate")
    public String mainPage(Model model) {
        List<MateVO> mateList = mateService.getAllMates();
        model.addAttribute("mateList", mateList);
        return "mate/mate";
    }

    // 유아 동반 데이터 API
    @GetMapping("/api/mate/infants")
    @ResponseBody
    public List<MateVO> getInfantData() {
        return mateService.getInfantData();
    }

    // 반려동물 동반 데이터 API
    @GetMapping("/api/mate/pets")
    @ResponseBody
    public List<MateVO> getPetData() {
        return mateService.getPetData();
    }

    // 통합 데이터 API
    @GetMapping("/api/mate/combined")
    @ResponseBody
    public List<MateVO> getCombinedData() {
        return mateService.getCombinedData();
    }

}