package fs.four.dropout.community.controller;

import fs.four.dropout.community.service.CommunityWriteService;
import fs.four.dropout.community.vo.CommunityWriteVO;
import fs.four.dropout.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

@Controller("communityWriteController")
public class CommunityWriteControllerImpl implements CommunityWriteController {

    @Autowired
    private CommunityWriteService communityWriteService;


    @Autowired
    private CommunityWriteVO communityWriteVO;
    @Autowired
    private UserVO userVO;

    @GetMapping("/communitywrite")
    public String communitywritePage() {
        return "community/communitywrite";
    }

    @Override
    @PostMapping("/community/save")
    public ModelAndView addCommunityWrite(@ModelAttribute("communityWrite") CommunityWriteVO communityWrite,
                                          @RequestParam("file") MultipartFile file,
                                          HttpServletRequest request,
                                          HttpServletResponse response,
                                          HttpSession session,
                                          RedirectAttributes redirectAttributes) throws Exception {

        request.setCharacterEncoding("utf-8");

        UserVO userVO = (UserVO) session.getAttribute("user");
        if (userVO == null) {
            redirectAttributes.addFlashAttribute("message", "로그인한 사용자만 글을 쓸 수 있습니다.");
            return new ModelAndView("redirect:/login");
        }

        System.out.println("Logged-in user ID: " + userVO.getUsr_id());
        System.out.println("Logged-in user Nickname: " + userVO.getUsr_nickname());

        if (file.isEmpty()) {
            communityWrite.setCom_thumbnail_path("/images/default.jpg");
        } else {
            String uploadDir = new File("src/main/resources/static/images/community/").getAbsolutePath();
            String fileName = file.getOriginalFilename();

            File uploadFile = new File(uploadDir + "/" + fileName);
            file.transferTo(uploadFile);

            communityWrite.setCom_thumbnail_path("/images/community/" + fileName);
        }

        System.out.println("이미지 경로 확인" + communityWrite.getCom_thumbnail_path());

        communityWrite.setUsr_id(userVO.getUsr_id());
        communityWrite.setUsr_nickname(userVO.getUsr_nickname());
        String comDuration = communityWrite.getCom_duration();

        int result = 0;

        result = communityWriteService.addCommunityWrite(communityWrite);

        ModelAndView mav = new ModelAndView("redirect:/community");
        return mav;
    }
}
