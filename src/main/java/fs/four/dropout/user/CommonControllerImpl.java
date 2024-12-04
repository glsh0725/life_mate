package fs.four.dropout.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonControllerImpl {

    @GetMapping("/forgot")
    public String forgotPage() {
        return "user/forgot";
    }

    @GetMapping("/userinfo")
    public String userinfoPage() {
        return "user/userinfo";
    }
}
