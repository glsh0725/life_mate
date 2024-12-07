package fs.four.dropout.user.dao;

import fs.four.dropout.user.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDAO {

    public UserVO UserLogin(UserVO userVO) throws Exception;
}
