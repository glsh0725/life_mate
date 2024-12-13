package fs.four.dropout.community.dao;

import fs.four.dropout.community.vo.CommunityViewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommunityViewDAO {
    @Select("SELECT * FROM lm_community WHERE com_post_number = #{id}")
    CommunityViewVO selectPostById(@Param("id") int id);
}
