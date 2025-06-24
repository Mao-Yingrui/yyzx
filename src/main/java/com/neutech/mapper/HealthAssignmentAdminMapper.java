package com.neutech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neutech.entity.HealthAssignment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HealthAssignmentAdminMapper extends BaseMapper<HealthAssignment> {
    List<HealthAssignment> selectAllAssignments();

    int insertAssignment(@Param("et") HealthAssignment assignment);

    int deleteAssignmentByIds(@Param("healthHomeId") Integer healthHomeId, @Param("userId") String userId);

    int deleteHealthAssignmentsByUserId(String userId);
}