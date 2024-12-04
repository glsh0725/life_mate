package fs.four.dropout.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityWriteControllerImpl {

    @GetMapping("/communitywrite")
    public String communitywritePage() {
        return "community/communitywrite";
    }
}
