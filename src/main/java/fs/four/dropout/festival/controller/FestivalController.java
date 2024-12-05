package fs.four.dropout.festival.controller;

import org.springframework.ui.Model;

public interface FestivalController {
    String festivalPage(int page, String date, String address, Model model);
}