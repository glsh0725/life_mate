package fs.four.dropout.community.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface CommunityController {

    public ModelAndView listPosts(HttpServletRequest request,
                                  HttpServletResponse response) throws Exception;
}
