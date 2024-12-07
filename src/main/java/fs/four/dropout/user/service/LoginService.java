package fs.four.dropout.user.service;

import fs.four.dropout.user.vo.UserVO;

public interface LoginService {

    public UserVO login(UserVO userVO) throws Exception;
}
