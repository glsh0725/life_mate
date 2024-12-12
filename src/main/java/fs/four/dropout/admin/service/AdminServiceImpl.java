package fs.four.dropout.admin.service;

import fs.four.dropout.admin.dao.AdminDAO;
import fs.four.dropout.admin.vo.AdminVO;
import fs.four.dropout.community.vo.CommunityVO;
import fs.four.dropout.user.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private UserVO userVO;
    @Autowired
    private SqlSession sqlSession;

    /* 회원 관리 기능 */
    @Override
    public List listUsers() throws Exception {
        List usersList = null;
        usersList = adminDAO.selectAllUserList();
        return usersList;
    }

    @Override
    public List listCommunity() throws Exception {
        List communityList = null;
        communityList = adminDAO.selectAllCommunityList();
        return communityList;
    }

    @Override
    public List<UserVO> selectUserList(UserVO userVO) {
        return sqlSession.selectList("adminMapper.selectUserList", userVO);
    }

    @Override
    public List<CommunityVO> selectCommunityList(CommunityVO communityVO) {
        return sqlSession.selectList("adminMapper.selectCommunityList", communityVO);
    }

    /* 회원 삭제 기능 */
    @Override
    public int removeUser(String id) throws Exception {
        return adminDAO.deleteUser(id);
    }

    /* 커뮤니티 글 삭제 기능 */
    @Override
    public int removeCommunity(String number) throws Exception {
        return adminDAO.deleteCommunity(number);
    }

    @Override
    public List<UserVO> listUsersPaging(int page, int size) {
        int offset = page * size;
        return adminDAO.listUsersPaging(offset, size);
    }

    @Override
    public int getTotalUser() {
        return adminDAO.getTotalUser();
    }
}
