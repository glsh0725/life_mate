package fs.four.dropout.user.controller;

import fs.four.dropout.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

public interface CommonController {

    public ModelAndView addUser(@ModelAttribute("info")UserVO userVO,
                                HttpServletRequest request,
                                HttpServletResponse response) throws Exception;
}
