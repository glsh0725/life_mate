package fs.four.dropout.community.dao;

import fs.four.dropout.community.vo.CommunityWriteVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

@Mapper
public interface CommunityWriteDAO {

    public int insertCommunityWrite(CommunityWriteVO communityWriteVO) throws DataAccessException;
}
