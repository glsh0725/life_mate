package fs.four.dropout.admin.dao;

import fs.four.dropout.community.vo.CommunityVO;
import fs.four.dropout.user.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import javax.xml.crypto.Data;
import java.util.List;

@Mapper
public interface AdminDAO {

    public List selectAllUserList() throws DataAccessException;

    public List selectAllCommunityList() throws DataAccessException;

    public int deleteUser(String id) throws DataAccessException;

    public int deleteCommunity(String number) throws DataAccessException;

    List<UserVO> listUsersPaging(@Param("offset") int offset, @Param("pageSize") int pageSize);

    int getTotalUser();

    List<CommunityVO> listCommunityPaging(@Param("offset") int offset, @Param("pageSize") int pageSize);
    int getTotalCommunity();

}
