package fs.four.dropout.community.controller;

import fs.four.dropout.community.vo.CommunityViewVO;
import fs.four.dropout.community.vo.CommunityWriteVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface CommunityViewController {

    public ModelAndView addCommunityWrite(@ModelAttribute("content") CommunityViewVO communityViewVO,
                                          HttpServletRequest request,
                                          HttpServletResponse response,
                                          HttpSession session,
                                          RedirectAttributes redirectAttributes) throws Exception;
}
