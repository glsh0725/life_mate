package fs.four.dropout.mate.controller;

import fs.four.dropout.mate.service.MateService;
import fs.four.dropout.mate.vo.MateVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MateControllerImpl implements MateController {

    private final MateService mateService;

    public MateControllerImpl(MateService mateService) {
        this.mateService = mateService;
    }

    @GetMapping("/mateform")
    public String mateformPage(Model model) {

        List<MateVO> mateList;

        /*int totalMate = mateList.size();
        int totalPages = (int) Math.ceil((double) totalMate / pageSize);

        int startIndex = (page - 1) * pageSize;
        int end Index = Math.min(startIndex + pageSize, mateList.size());
        List<MateVO> mateListForPage = mateList.subList(startIndex, endIndex);

        model.addAttribute("mateList", mateListForPage);*/

        return "mate/mateform";
    }

    @GetMapping("/mate")
    public String matePage() {
        return "mate/mate";
    }

    @GetMapping("/mateform/list")
    public String matelist() {
        return "mate/mateform";
    }
}
