package fs.four.dropout.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fs.four.dropout.community.dao.CommunityViewDAO;
import fs.four.dropout.community.vo.CommunityViewVO;

@Service("communityViewService")
public class CommunityViewServiceImpl implements CommunityViewService {

    @Autowired
    private CommunityViewDAO communityViewDAO;

    @Override
    public CommunityViewVO getPostById(int id) {
        return communityViewDAO.selectPostById(id);
    }

    @Override
    public CommunityViewVO getCommunityView(int postId) {
        return null;
    }
}
