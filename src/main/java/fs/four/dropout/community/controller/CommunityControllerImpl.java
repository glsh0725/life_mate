package fs.four.dropout.community.controller;

import fs.four.dropout.community.service.CommunityService;
import fs.four.dropout.community.vo.CommunityVO;
import fs.four.dropout.community.vo.CommunityWriteVO;
import fs.four.dropout.community.vo.CommunityViewVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("communityController")
public class CommunityControllerImpl implements CommunityController {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private CommunityVO communityVO;

    @Autowired
    private CommunityWriteVO communityWriteVO;

    @Override
    @GetMapping("/community")
    public ModelAndView listPosts(HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {

        List postsList = communityService.listPosts();

        ModelAndView mav = new ModelAndView("/community/community");

        mav.addObject("postsList", postsList);
        return mav;
    }

    @GetMapping("/community/save")
    public String communitySave() {
        return "community/save";
    }

    // 게시글 상세 보기 기능 추가
    @GetMapping("/community/view")
    public ModelAndView viewPost(@RequestParam("postId") Number postId) {
        ModelAndView mav = new ModelAndView("community/communityview");  // views/community/communityview.jsp
        mav.addObject("postId", postId);
        return mav;
    }
}
