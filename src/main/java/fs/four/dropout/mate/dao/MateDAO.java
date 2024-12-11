package fs.four.dropout.mate.dao;

import fs.four.dropout.mate.vo.MateVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MateDAO {
    boolean existsByFacilityName(@Param("facilityName") String facilityName);

    void insertCombinedData(MateVO mateVO);
}