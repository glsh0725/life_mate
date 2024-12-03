package com.lifemate.getaway.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/join")
    public String joinPage() {
        return "user/join";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/forgot")
    public String forgotPage() {
        return "user/forgot";
    }

    @GetMapping("/userinfo")
    public String userinfoPage() {
        return "user/userinfo";
    }
}
