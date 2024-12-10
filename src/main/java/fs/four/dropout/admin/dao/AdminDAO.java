package fs.four.dropout.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface AdminDAO {

    public List selectAllUserList() throws DataAccessException;

    public List selectAllCommunityList() throws DataAccessException;
}
