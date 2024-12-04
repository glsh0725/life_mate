package fs.four.dropout.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginServiceImpl {
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }
}
