package fs.four.dropout.user.service;

import fs.four.dropout.user.dao.LoginDAO;
import fs.four.dropout.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
@Transactional(propagation = Propagation.REQUIRED)
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO loginDAO;

    @Override
    public UserVO login(UserVO userVO) throws Exception{
        return loginDAO.UserLogin(userVO);
    }

}
