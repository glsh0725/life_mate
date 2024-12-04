package fs.four.dropout.festival;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FestivalControllerImpl {
    @GetMapping("/festival")
    public String festivalPage() {
        return "festival/festival";
    }
}