package fs.four.dropout.user.controller;

import fs.four.dropout.user.service.JoinService;
import fs.four.dropout.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("commonController")
public class CommonControllerImpl implements CommonController {

    @Autowired
    private JoinService joinService;

    @Autowired
    private UserVO userVO;

    @GetMapping("/forgot")
    public String forgotPage() {
        return "user/forgot";
    }

    @GetMapping("/userinfo")
    public String userinfoPage() {
        return "user/userinfo";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "user/join";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    @Override
    @PostMapping("/join")
    public ModelAndView addUser(@ModelAttribute("user") UserVO user,
                                HttpServletRequest request, HttpServletResponse response) throws Exception{

        request.setCharacterEncoding("utf-8");
        int result = 0;

        result = joinService.addUser(user);
                                                    // 메인 페이지 리다이렉트
        ModelAndView mav = new ModelAndView("redirect:/main");
        return mav;

    }
}
