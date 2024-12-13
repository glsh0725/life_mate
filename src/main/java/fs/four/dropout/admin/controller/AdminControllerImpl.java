package fs.four.dropout.admin.controller;

import fs.four.dropout.admin.service.AdminService;
import fs.four.dropout.admin.vo.AdminVO;
import fs.four.dropout.community.vo.CommunityVO;
import fs.four.dropout.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("adminController")
public class AdminControllerImpl implements AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserVO userVO;

    @Autowired
    private AdminVO adminVO;

    @Autowired
    private CommunityVO communityVO;

    @Override
    @GetMapping("/admin")
    public ModelAndView listUsersPaging(HttpServletRequest request,
                                  HttpServletResponse response,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "0") int communityPage,
                                        @RequestParam(defaultValue = "10") int communitySize) throws Exception {
        List<UserVO> userListPage = adminService.listUsersPaging(page, size);

        int totalUsers = adminService.getTotalUser();

        List<CommunityVO> communityListPage = adminService.listCommunityPaging(communityPage, communitySize);
        int totalCommunity = adminService.getTotalCommunity();

        ModelAndView mav = new ModelAndView("/admin/admin");

        mav.addObject("usersList", userListPage);
        mav.addObject("communityList", communityListPage);

        mav.addObject("totalPages", (int) Math.ceil((double) totalUsers / size));
        mav.addObject("currentPage", page);
        mav.addObject("totalCommunityPages", (int) Math.ceil((double) totalCommunity / communitySize));
        mav.addObject("currentCommunityPage", communityPage);
        return mav;
    }

    @GetMapping("/list")
    public String selectUserList(Model model, UserVO userVO, CommunityVO communityVO) {
        model.addAttribute("userList", adminService.selectUserList(userVO));
        model.addAttribute("communityList", adminService.selectCommunityList(communityVO));

        return "/admin/admin";
    }

    /* 회원 삭제 기능 */
    @Override
    @GetMapping("/admin/removeUser")
    public ModelAndView removeUser(@RequestParam("id") String id,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        adminService.removeUser(id);
        ModelAndView mav = new ModelAndView("redirect:/admin");
        return mav;
    }

    /* 커뮤니티 글 삭제 기능 */
    @Override
    @GetMapping("/admin/removeCommunity")
    public ModelAndView removeCommunity(@RequestParam("number") String number,
                                        HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        adminService.removeCommunity(number);
        ModelAndView mav = new ModelAndView("redirect:/admin");
        return mav;
    }

}
