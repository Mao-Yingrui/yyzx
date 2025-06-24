package com.neutech.controller;

import com.neutech.entity.UserCareServiceVO;
import com.neutech.service.UserCareServiceService;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health-manager/care-service")
public class UserCareServiceController {

    @Autowired
    private UserCareServiceService userCareServiceService;

    /**
     * 健康管家查看用户服务页面
     * 传入：
     * 身份证号（id_card）：字符串
     * 传出json格式：
     * 护理服务ID (care_id)
     * 护理服务(care_details) ：字符串
     * 护理内容剩余次数（remaining_sessions）：int
     */
    @GetMapping("/user-services")
    public ResultJson getUserCareServices(@RequestParam String idCard) {
        List<UserCareServiceVO> services = userCareServiceService.getUserCareServices(idCard);
        return new ResultJson(200, services, "查询成功");
    }

    /**
     * 健康管家记录用户服务页面
     * 健康管家传入json格式：
     * 护理服务ID (care_id)
     * 护理内容剩余次数（remaining_sessions）：int
     * 传出json格式：
     * "操作成功"或"操作失败"
     */
    @PostMapping("/update-service")
    public ResultJson updateUserCareService(
            @RequestParam Integer careId,
            @RequestParam Integer remainingCount) {
        boolean result = userCareServiceService.updateUserCareServiceRemainingCount(careId, remainingCount);
        return result ? new ResultJson(200, "操作成功", "操作成功") : new ResultJson(500, "操作失败", "操作失败");
    }
}