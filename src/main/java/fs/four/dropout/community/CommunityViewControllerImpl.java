package fs.four.dropout.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityViewControllerImpl {

    @GetMapping("/communityview")
    public String communityviewPage() {
        return "community/communityview";
    }
}
