package com.neutech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neutech.entity.Bed;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BedAdminMapper extends BaseMapper<Bed> {
    List<Bed> selectFreeBeds();

    Bed selectBedById(@Param("bedId") Integer bedId);

    int updateBedStatusAndUser(@Param("bedId") Integer bedId, @Param("userId") String userId);
}