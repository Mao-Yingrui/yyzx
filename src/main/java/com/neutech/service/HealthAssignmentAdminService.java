package com.neutech.service;

import com.neutech.entity.HealthAssignment;
import java.util.List;

public interface HealthAssignmentAdminService {
    List<HealthAssignment> listAllAssignments();
    boolean assignManager(HealthAssignment assignment);
    boolean unassignManager(Integer healthHomeId, String userId);

    /**
     * 删除指定用户ID的所有健康分配记录
     * @param userId 用户ID
     * @return 删除操作是否成功
     */
    boolean deleteHealthAssignmentsByUserId(String userId);
}