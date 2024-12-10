package fs.four.dropout.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("communityViewController")
public class CommunityViewControllerImpl implements CommunityViewController {

    @GetMapping("/communityview")
    public String communityviewPage() {
        return "community/communityview";
    }

}
