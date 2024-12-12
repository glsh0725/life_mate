package fs.four.dropout.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminController {

    public ModelAndView listUsersPaging(HttpServletRequest request,
                                  HttpServletResponse response,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) throws Exception;

    public ModelAndView removeUser(@RequestParam("id") String id,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception;

    public ModelAndView removeCommunity(@RequestParam("number") String number,
                                        HttpServletRequest request,
                                        HttpServletResponse response) throws Exception;
}
