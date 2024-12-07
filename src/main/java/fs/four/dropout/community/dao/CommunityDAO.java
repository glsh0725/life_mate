package fs.four.dropout.community.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface CommunityDAO {

    public List selectAllPostList() throws DataAccessException;
}
