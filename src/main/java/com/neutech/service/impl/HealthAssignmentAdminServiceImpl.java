package com.neutech.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neutech.entity.HealthAssignment;
import com.neutech.mapper.HealthAssignmentAdminMapper;
import com.neutech.service.HealthAssignmentAdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthAssignmentAdminServiceImpl extends ServiceImpl<HealthAssignmentAdminMapper, HealthAssignment> implements HealthAssignmentAdminService {
    private final HealthAssignmentAdminMapper healthAssignmentAdminMapper;

    public HealthAssignmentAdminServiceImpl(HealthAssignmentAdminMapper healthAssignmentAdminMapper) {
        this.healthAssignmentAdminMapper = healthAssignmentAdminMapper;
    }

    @Override
    public List<HealthAssignment> listAllAssignments() {
        return this.healthAssignmentAdminMapper.selectAllAssignments();
    }

    @Override
    public boolean assignManager(HealthAssignment assignment) {
        return this.healthAssignmentAdminMapper.insertAssignment(assignment) > 0;
    }

    @Override
    public boolean unassignManager(Integer healthHomeId, String userId) {
        return this.healthAssignmentAdminMapper.deleteAssignmentByIds(healthHomeId, userId) > 0;
    }

    @Override
    public boolean deleteHealthAssignmentsByUserId(String userId) {
        int rowsAffected = healthAssignmentAdminMapper.deleteHealthAssignmentsByUserId(userId);
        return rowsAffected > 0;
    }

}