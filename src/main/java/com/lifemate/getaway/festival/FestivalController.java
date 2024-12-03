package com.lifemate.getaway.festival;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FestivalController {

    @GetMapping("/festival")
    public String festivalPage() {
        return "festival/festival";
    }
}
