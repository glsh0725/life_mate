package fs.four.dropout.community.controller;

import fs.four.dropout.community.service.CommunityWriteService;
import fs.four.dropout.community.vo.CommunityWriteVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("communityWriteController")
public class CommunityWriteControllerImpl implements CommunityWriteController {

    @Autowired
    private CommunityWriteService communityWriteService;


    @Autowired
    private CommunityWriteVO communityWriteVO;

    @GetMapping("/communitywrite")
    public String communitywritePage() {
        return "community/communitywrite";
    }

    @Override
    @PostMapping("/community/save")
    public ModelAndView addCommunityWrite(@ModelAttribute("communityWrite") CommunityWriteVO communityWrite,
                                          HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("utf-8");
        int result = 0;

        result = communityWriteService.addCommunityWrite(communityWrite);

        ModelAndView mav = new ModelAndView("redirect:/community");
        return mav;
    }
}
