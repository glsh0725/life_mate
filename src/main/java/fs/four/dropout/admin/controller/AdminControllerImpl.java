package fs.four.dropout.admin.controller;

import fs.four.dropout.admin.service.AdminService;
import fs.four.dropout.admin.vo.AdminVO;
import fs.four.dropout.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("adminController")
public class AdminControllerImpl implements AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserVO userVO;

    @Autowired
    private AdminVO adminVO;

    @GetMapping("/admin")
    public String adminPage() {
        return "admin/admin";
    }

    @Override
    @GetMapping("/admin/admin")
    public ModelAndView listUsers(HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {

        List usersList = adminService.listUsers();

        ModelAndView mav = new ModelAndView("/admin/admin");

        mav.addObject("usersList", usersList);
        return mav;
    }
}
