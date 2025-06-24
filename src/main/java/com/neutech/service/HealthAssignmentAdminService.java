package com.neutech.service;

import com.neutech.entity.HealthAssignment;

import java.util.List;

public interface HealthAssignmentAdminService {
    List<HealthAssignment> listAllAssignments();
    boolean assignManager(HealthAssignment assignment);
    boolean unassignManager(Integer healthHomeId, String userId);
}