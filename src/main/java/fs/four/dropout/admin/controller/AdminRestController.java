package fs.four.dropout.admin.controller;

import fs.four.dropout.admin.service.AdminRestService;
import fs.four.dropout.admin.service.AdminServiceImpl;
import fs.four.dropout.admin.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/admin"})

public class AdminRestController {

    @Autowired
    private AdminRestService adminRestService;
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private AdminVO adminVO;

    @GetMapping("/userlist")
    public ResponseEntity<List> listUsers() throws Exception {
        return new ResponseEntity<>(adminRestService.listAllUser(),
                HttpStatus.OK);
    }

    @GetMapping("/communitylist")
    public ResponseEntity<List> listCommunity() throws Exception{
        return new ResponseEntity<>(adminRestService.listAllCommunity(),
                HttpStatus.OK);
    }

}
