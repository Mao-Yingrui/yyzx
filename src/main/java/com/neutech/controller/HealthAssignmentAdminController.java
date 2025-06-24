package com.neutech.controller;

import com.neutech.entity.HealthAssignment;
import com.neutech.service.HealthAssignmentAdminService;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 管理员 - 健康管家用户分配管理控制器
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
@RestController
@RequestMapping("/admin/health_assignment")
public class HealthAssignmentAdminController {
    @Autowired
    private HealthAssignmentAdminService healthAssignmentAdminService;

    /**
     * 查看所有健康管家与用户的分配关系
     *
     * @return ResultJson 包含分配关系列表及操作状态
     */
    @GetMapping("/list")
    public ResultJson listAllAssignments() {
        try {
            List<HealthAssignment> assignments = healthAssignmentAdminService.listAllAssignments();
            return new ResultJson(200, assignments, "查询成功");
        } catch (Exception e) {
            return new ResultJson(500, null, "系统异常：" + e.getMessage());
        }
    }

    /**
     * 分配健康管家
     *
     * @param healthHomeId 健康家ID
     * @param userId 用户身份证号
     * @return ResultJson 操作结果
     */
    @PostMapping("/assign")
    public ResultJson assignManager(
            @RequestParam(required = false) Integer healthHomeId,
            @RequestParam(required = false) String userId
    ) {
        if (healthHomeId == null || userId == null || userId.trim().isEmpty()) {
            return new ResultJson(400, null, "参数不能为空");
        }

        HealthAssignment assignment = new HealthAssignment();
        assignment.setHealthHomeId(healthHomeId);
        assignment.setUserId(userId);

        try {
            boolean result = healthAssignmentAdminService.assignManager(assignment);
            return result ? new ResultJson(200, null, "分配成功") : new ResultJson(500, null, "分配失败");
        } catch (Exception e) {
            return new ResultJson(500, null, "分配过程中发生异常：" + e.getMessage());
        }
    }

    /**
     * 解除健康管家与用户的管理关系
     *
     * @param healthHomeId 健康家ID
     * @param userId 用户身份证号
     * @return ResultJson 操作结果
     */
    @DeleteMapping("/unassign")
    public ResultJson unassignManager(
            @RequestParam(required = false) Integer healthHomeId,
            @RequestParam(required = false) String userId
    ) {
        if (healthHomeId == null || userId == null || userId.trim().isEmpty()) {
            return new ResultJson(400, null, "参数不能为空");
        }

        try {
            boolean result = healthAssignmentAdminService.unassignManager(healthHomeId, userId);
            return result ? new ResultJson(200, null, "解除成功") : new ResultJson(500, null, "解除失败");
        } catch (Exception e) {
            return new ResultJson(500, null, "解除过程中发生异常：" + e.getMessage());
        }
    }
}