package fs.four.dropout.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityViewControllerImpl {

    @GetMapping("/communityview")
    public String communityviewPage() {
        return "community/communityview";
    }
}
