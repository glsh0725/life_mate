package fs.four.dropout.community.service;

import fs.four.dropout.community.vo.CommunityViewVO;

import java.util.List;

public interface CommunityService {

    public List listPosts() throws Exception;

    CommunityViewVO getPostById(Number postId);
}
