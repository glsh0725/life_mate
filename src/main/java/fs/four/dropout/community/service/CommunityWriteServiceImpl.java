package fs.four.dropout.community.service;

import fs.four.dropout.community.dao.CommunityWriteDAO;
import fs.four.dropout.community.vo.CommunityVO;
import fs.four.dropout.community.vo.CommunityWriteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("communityWriteService")
@Transactional(propagation = Propagation.REQUIRED)
public class CommunityWriteServiceImpl implements CommunityWriteService {

    @Autowired
    private CommunityWriteVO communityWriteVO;

    @Autowired
    private CommunityVO communityVO;

    @Autowired
    private CommunityWriteDAO communityWriteDAO;

    @Override
    public int addCommunityWrite(CommunityWriteVO communityWrite) throws Exception {
        return communityWriteDAO.insertCommunityWrite(communityWrite);
    }
}
