package fs.four.dropout.mate.controller;

import fs.four.dropout.mate.vo.MateVO;
import java.util.List;

public interface MateController {

    List<MateVO> getInfantData();
    List<MateVO> getPetData();
    List<MateVO> getCombinedData();
}