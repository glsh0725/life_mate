package fs.four.dropout.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminControllerImpl {

    @GetMapping("/admin")
    public String adminPage() {
        return "admin/admin";
    }
}
