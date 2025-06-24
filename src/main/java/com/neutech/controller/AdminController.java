package com.neutech.controller;

import com.neutech.service.AdminService;
import com.neutech.service.CheckoutRecordService;
import com.neutech.vo.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p >
 *
 * @author Morrien
 * @since 2025-06-21
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @Autowired
    CheckoutRecordService checkoutRecordService;

    @PostMapping("/login")
    ResultJson login(
            @RequestParam String adId,
            @RequestParam String adPwd
    ) {
        boolean isValid = adminService.login(adId, adPwd);
        if (isValid) {
            return new ResultJson(200, null, "登录成功");
        } else {
            return new ResultJson(500, null, "账号或密码错误");
        }
    }

    @GetMapping("/checkout/list")
    ResultJson getCheckoutApplications() {
        try {
            List<Map<String, Object>> applications = checkoutRecordService.getCheckoutApplications();
            return ResultJson.success(applications);
        } catch (Exception e) {
            return ResultJson.fail("获取退住申请失败: " + e.getMessage());
        }
    }

    @PutMapping("/checkout/approve")
    ResultJson approveApplication(@RequestParam String user_id) {
        try {
            boolean result = checkoutRecordService.approveApplication(user_id);
            if (result) {
                return ResultJson.success("同意申请成功");
            } else {
                return ResultJson.fail("同意申请失败");
            }
        } catch (Exception e) {
            return ResultJson.fail("同意申请失败: " + e.getMessage());
        }
    }

    @PutMapping("/checkout/reject")
    ResultJson rejectApplication(@RequestParam String user_id) {
        try {
            boolean result = checkoutRecordService.rejectApplication(user_id);
            if (result) {
                return ResultJson.success("不同意申请成功");
            } else {
                return ResultJson.fail("不同意申请失败");
            }
        } catch (Exception e) {
            return ResultJson.fail("不同意申请失败: " + e.getMessage());
        }
    }

    @PutMapping("/checkout/update")
    ResultJson updateApplication(@RequestParam(required = false) String user_id, @RequestParam(required = false) int bed_id, @RequestParam(required = false) java.time.LocalDateTime checkout_time) {
        try {
            // 参数验证
            if (user_id == null || bed_id == 0 || checkout_time == null) {
                return ResultJson.fail("缺少必要参数：user_id、bed_id和checkout_time必须提供");
            }

            boolean result = checkoutRecordService.updateApplication(user_id, bed_id, checkout_time);
            if (result) {
                return ResultJson.success("修改申请成功");
            } else {
                return ResultJson.fail("修改申请失败");
            }
        } catch (Exception e) {
            return ResultJson.fail("修改申请失败: " + e.getMessage());
        }
    }

    @DeleteMapping("/checkout/delete")
    ResultJson deleteApplication(@RequestParam String user_id) {
        try {
            boolean result = checkoutRecordService.deleteApplication(user_id);
            if (result) {
                return ResultJson.success("删除申请成功");
            } else {
                return ResultJson.fail("删除申请失败");
            }
        } catch (Exception e) {
            return ResultJson.fail("删除申请失败: " + e.getMessage());
        }
    }
}