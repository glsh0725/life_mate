package fs.four.dropout.community.service;

import fs.four.dropout.community.dao.CommunityDAO;
import fs.four.dropout.community.vo.CommunityVO;
import fs.four.dropout.community.vo.CommunityViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("communityService")
@Transactional(propagation = Propagation.REQUIRED)
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityDAO communityDAO;

    @Autowired
    private CommunityVO communityVO;

    @Override
    public List listPosts() throws Exception{
        List postsList = null;
        postsList = communityDAO.selectAllPostList();

        return postsList;
    }

    @Override
    public CommunityViewVO getPostById(Number postId) {
        return null;
    }
}
