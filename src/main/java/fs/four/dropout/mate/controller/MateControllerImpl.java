package fs.four.dropout.mate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MateControllerImpl implements MateController {

    @GetMapping("/mateform")
    public String mateformPage() {
        return "mate/mateform";
    }

    @GetMapping("/mate")
    public String matePage() {
        return "mate/mate";
    }

}
