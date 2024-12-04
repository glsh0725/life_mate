package fs.four.dropout.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JoinServiceImpl {

    @GetMapping("/join")
    public String joinPage() {
        return "user/join";
    }
}
