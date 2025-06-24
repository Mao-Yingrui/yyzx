package com.neutech.controller;

import com.neutech.entity.OutingRecord;
import com.neutech.service.OutingRecordService;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 外出记录控制器
 */
@RestController
@RequestMapping("admin/outing")
public class OutingRecordController {
    @Autowired
    private OutingRecordService outingRecordService;

    /**
     * 查看用户申请
     * @return 所有申请信息
     */
    @GetMapping("/applications")
    public ResultJson getAllApplications() {
        return ResultJson.success(outingRecordService.getAllApplications());
    }

    /**
     * 审核用户申请
     * @param userId 用户身份证号
     * @return 操作结果
     */
    @PostMapping("/approve")
    public ResultJson approveApplication(@RequestParam String userId) {
        boolean result = outingRecordService.approveApplication(userId);
        return result ? ResultJson.success("审核成功") : ResultJson.fail("审核失败");
    }

    /**
     * 查看出外用户
     * @return 已通过的外出用户信息
     */
    @GetMapping("/approved")
    public ResultJson getApprovedOutings() {
        return ResultJson.success(outingRecordService.getApprovedOutings());
    }

    /**
     * 外出回归登记
     * @param userId 用户身份证号
     * @return 操作结果
     */
    @PostMapping("/return")
    public ResultJson registerReturn(@RequestParam String userId) {
        boolean result = outingRecordService.registerReturn(userId);
        return result ? ResultJson.success("登记成功") : ResultJson.fail("登记失败");
    }

    /**
     * 修改用户申请信息
     * @param userId 用户身份证号
     * @param name 用户姓名
     * @param outingTime 外出时间
     * @param outingReason 外出原因
     * @param destination 目的地
     * @return 操作结果
     */
    @PostMapping("/update")
    public ResultJson updateApplication(@RequestParam String userId,
                                        @RequestParam String name,
                                        @RequestParam String outingTime,
                                        @RequestParam String outingReason,
                                        @RequestParam String destination) {
        boolean result = outingRecordService.updateApplication(userId, name, outingTime, outingReason, destination);
        return result ? ResultJson.success("修改成功") : ResultJson.fail("修改失败");
    }

    /**
     * 删除用户信息
     * @param outingId 外出记录ID
     * @return 操作结果
     */
    @DeleteMapping("/{outingId}")
    public ResultJson deleteApplicationById(@PathVariable Integer outingId) {
        boolean result = outingRecordService.deleteApplicationById(outingId);
        return result ? ResultJson.success("删除成功") : ResultJson.fail("删除失败");
    }
}