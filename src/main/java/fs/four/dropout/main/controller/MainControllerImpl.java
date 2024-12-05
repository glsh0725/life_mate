package fs.four.dropout.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllerImpl {

    @GetMapping("/main")
    public String mainPage() {
        return "main/main";
    }
}