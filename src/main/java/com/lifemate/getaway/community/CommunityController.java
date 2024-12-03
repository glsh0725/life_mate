package com.lifemate.getaway.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {

    @GetMapping("/community")
    public String communityPage() {
        return "community/community";
    }

}
