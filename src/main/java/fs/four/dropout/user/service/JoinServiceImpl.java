package fs.four.dropout.user.service;

import fs.four.dropout.admin.dao.AdminDAO;
import fs.four.dropout.user.dao.JoinDAO;
import fs.four.dropout.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Service("joinService")
@Transactional(propagation = Propagation.REQUIRED)
public class JoinServiceImpl implements JoinService {

    @Autowired
    private JoinDAO joinDAO;

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public int addUser(UserVO user) throws Exception{
        return joinDAO.insertUser(user);
    }

}
