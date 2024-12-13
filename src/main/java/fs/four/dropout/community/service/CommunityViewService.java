package fs.four.dropout.community.service;

import fs.four.dropout.community.vo.CommunityViewVO;

public interface CommunityViewService {

    CommunityViewVO getPostById(int id);

    CommunityViewVO getCommunityView(int postId);
}
