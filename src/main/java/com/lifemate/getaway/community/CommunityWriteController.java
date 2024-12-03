package com.lifemate.getaway.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityWriteController {

    @GetMapping("/communitywrite")
    public String communitywritePage() {
        return "community/communitywrite";
    }
}
