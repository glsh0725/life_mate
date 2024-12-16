package fs.four.dropout.community.controller;

import fs.four.dropout.community.service.CommunityViewService;
import fs.four.dropout.community.vo.CommunityViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommunityViewControllerImpl {

    @Autowired
    private CommunityViewService communityViewService;

    @Autowired
    private CommunityViewVO communityViewVO;

    @GetMapping("community/communityview")
    public String communityviewPage() {
        return "community/communityview";
    }

//    @GetMapping("/communityview")
//    public String communityviewPage(@RequestParam("id") int id, Model model) {
//        // postId로 게시물 가져오기
//        CommunityViewVO post = communityViewService.getPostById(id);
//        model.addAttribute("post", post);
//        // view 페이지를 반환
//        return "community/communityview";  // communityview.jsp로 매핑
//    }
}
