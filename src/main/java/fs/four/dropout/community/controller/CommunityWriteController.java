package fs.four.dropout.community.controller;

import fs.four.dropout.community.vo.CommunityWriteVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

public interface CommunityWriteController {

    public ModelAndView addCommunityWrite(@ModelAttribute("content")CommunityWriteVO communityWriteVO,
                                          HttpServletRequest request,
                                          HttpServletResponse response) throws Exception;
}
