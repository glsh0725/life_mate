package fs.four.dropout.community.controller;

import fs.four.dropout.community.service.CommunityWriteService;
import fs.four.dropout.community.vo.CommunityWriteVO;
import fs.four.dropout.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("communityWriteController")
public class CommunityWriteControllerImpl implements CommunityWriteController {

    @Autowired
    private CommunityWriteService communityWriteService;


    @Autowired
    private CommunityWriteVO communityWriteVO;
    @Autowired
    private UserVO userVO;

    @GetMapping("/communitywrite")
    public String communitywritePage() {
        return "community/communitywrite";
    }

    @Override
    @PostMapping("/community/save")
    public ModelAndView addCommunityWrite(@ModelAttribute("communityWrite") CommunityWriteVO communityWrite,
                                          HttpServletRequest request,
                                          HttpServletResponse response,
                                          HttpSession session,
                                          RedirectAttributes redirectAttributes) throws Exception {

        request.setCharacterEncoding("utf-8");

        UserVO userVO = (UserVO) session.getAttribute("user");
        if (userVO == null) {
            redirectAttributes.addFlashAttribute("message", "로그인한 사용자만 글을 쓸 수 있습니다.");
            return new ModelAndView("redirect:/login");
        }

        System.out.println("Logged-in user ID: " + userVO.getUsr_id());
        System.out.println("Logged-in user Nickname: " + userVO.getUsr_nickname());

        communityWrite.setUsr_id(userVO.getUsr_id());
        communityWrite.setUsr_nickname(userVO.getUsr_nickname());
        String comDuration = communityWrite.getCom_duration();

        int result = 0;

        result = communityWriteService.addCommunityWrite(communityWrite);

        ModelAndView mav = new ModelAndView("redirect:/community");
        return mav;
    }
}
