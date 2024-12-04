package fs.four.dropout.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityControllerImpl {
    @GetMapping("/community")
    public String communityPage() {
        return "community/community";
    }
}
