package fs.four.dropout.community.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommunityViewController {
    @GetMapping("/community/view")
    String communityViewPage(@RequestParam("postId") int postId, Model model);
}
