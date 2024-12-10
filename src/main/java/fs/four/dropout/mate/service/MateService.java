package fs.four.dropout.mate.service;

import fs.four.dropout.mate.vo.MateVO;
import java.util.List;

public interface MateService {

    List<MateVO> getInfantData();
    List<MateVO> getPetData();
    List<MateVO> getCombinedData();
}