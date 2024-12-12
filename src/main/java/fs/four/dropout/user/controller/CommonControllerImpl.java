package fs.four.dropout.user.controller;

import fs.four.dropout.user.service.JoinService;
import fs.four.dropout.user.service.LoginServiceImpl;
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

@Controller("commonController")
public class CommonControllerImpl implements CommonController {

    @Autowired
    private JoinService joinService;

    @Autowired
    private UserVO userVO;
    @Autowired
    private LoginServiceImpl loginService;

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
                                HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("utf-8");
        int result = 0;

        result = joinService.addUser(user);
        // 메인 페이지 리다이렉트
        ModelAndView mav = new ModelAndView("redirect:/main");
        return mav;

    }

    @Override
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") UserVO user,
                              RedirectAttributes rAttr,
                              HttpServletRequest request,
                              HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();
        userVO = loginService.login(user);
        if (userVO != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usr_id", userVO.getUsr_id());
            session.setAttribute("user", userVO);

            if("admin".equals(userVO.getRole())) {
                session.setAttribute("admin", true);
            }

            session.setAttribute("isLogOn", true);

            String action = (String) session.getAttribute("action");
            session.removeAttribute("action");
            if (action != null) {
                mav.setViewName("redirect:" + action);
            } else {
                mav.setViewName("redirect:/main");
            }
        } else {
            rAttr.addAttribute("result", "loginFailed");
            mav.setViewName("redirect:/login");
        }
        return mav;
    }

    @Override
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.setAttribute("isLogOn", false);

        ModelAndView mav = new ModelAndView();

        mav.setViewName("redirect:/main");
        return mav;
    }
}