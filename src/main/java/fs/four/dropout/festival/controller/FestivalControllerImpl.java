package fs.four.dropout.festival.controller;

import fs.four.dropout.festival.service.FestivalService;
import fs.four.dropout.festival.vo.FestivalVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FestivalControllerImpl implements FestivalController {

    private final FestivalService festivalService;

    public FestivalControllerImpl(FestivalService festivalService) {
        this.festivalService = festivalService;
    }

    @Override
    @GetMapping("/festival")
    public String festivalPage(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(required = false) String date,
                               @RequestParam(required = false) String address,
                               Model model) {

        if (date == null || date.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.format(new Date());
        }

        int pageSize = 9;
        int pageGroupSize = 10;

        List<FestivalVO> festivals;

        if (address != null && !address.isEmpty()) {
            festivals = festivalService.getFestivalsByDateAndAddress(date, address);
        } else if (date != null && !date.isEmpty()) {
            festivals = festivalService.getFestivalsByDate(date);
        } else {
            festivals = festivalService.getFestivalsByPage(page, pageSize);
        }

        int totalFestivals = festivals.size();
        int totalPages = (int) Math.ceil((double) totalFestivals / pageSize);

        int currentPageGroup = (page - 1) / pageGroupSize;
        int startPage = currentPageGroup * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        int prevGroup = (startPage > 1) ? startPage - 1 : 0;
        int nextGroup = (endPage < totalPages) ? endPage + 1 : 0;

        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, festivals.size());
        List<FestivalVO> festivalsForPage = festivals.subList(startIndex, endIndex);

        model.addAttribute("festivals", festivalsForPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("prevGroup", prevGroup);
        model.addAttribute("nextGroup", nextGroup);

        model.addAttribute("selectedDate", date);
        model.addAttribute("selectedAddress", address);

        return "festival/festival";
    }
}