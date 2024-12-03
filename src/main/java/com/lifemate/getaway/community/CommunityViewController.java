package com.lifemate.getaway.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityViewController {

    @GetMapping("/communityview")
    public String communityviewPage() {
        return "community/communityview";
    }
}
