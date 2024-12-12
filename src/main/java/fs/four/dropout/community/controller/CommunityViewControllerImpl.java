package fs.four.dropout.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("communityViewController")
public class CommunityViewControllerImpl {

    @GetMapping("/communityview")
    public String communityviewPage() {
        return "community/communityview";
    }

}
