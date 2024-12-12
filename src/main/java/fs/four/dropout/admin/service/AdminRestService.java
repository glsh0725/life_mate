package fs.four.dropout.admin.service;

import fs.four.dropout.admin.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminRestService {

    @Autowired
    private AdminDAO adminDAO;

    public List listAllUser() throws Exception {

        List userList = null;
        userList = adminDAO.selectAllUserList();
        return userList;
    }

    public List listAllCommunity() throws Exception {

        List communityList = null;
        communityList = adminDAO.selectAllCommunityList();
        return communityList;
    }

}
