package fs.four.dropout.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface AdminController {

    public ModelAndView listUsers(HttpServletRequest request,
                                  HttpServletResponse response) throws Exception;
}