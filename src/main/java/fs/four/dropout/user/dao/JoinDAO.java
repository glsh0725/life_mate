package fs.four.dropout.user.dao;

import fs.four.dropout.user.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

@Mapper
public interface JoinDAO {
    
    public int insertUser(UserVO userVO) throws DataAccessException;
}
