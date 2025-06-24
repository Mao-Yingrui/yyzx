package com.neutech.controller;

import com.neutech.entity.UserCareDetails;
import com.neutech.service.UserCareDetailsService;
import com.neutech.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/care")
public class UserCareController {

    @Autowired
    private UserCareDetailsService userCareDetailsService;

    /**
     * 用户查看护理内容页面
     * 传出json格式：
     * 护理内容(care_details) ：字符串
     */
    @GetMapping("/details")
    public ResultJson getCareDetails() {
        String careDetails = userCareDetailsService.getCareDetails();
        return new ResultJson(200, careDetails, "查询成功");
    }

    /**
     * 用户查看自己级别的护理内容页面
     * 用户传入json格式：
     * 护理级别（nursing_level）：无依赖/轻度依赖/中度依赖/重度依赖
     * 传出json格式：
     * 护理内容(care_details) ：字符串
     */
    @GetMapping("/level-details")
    public ResultJson getCareDetailsByLevel(@RequestParam String nursingLevel) {
        // 这里需要根据护理级别查询对应的护理内容
        // 实际项目中可能需要从数据库查询
        // 这里简化处理，直接返回固定字符串
        String careDetails = "根据" + nursingLevel + "级别提供的护理内容..."; // 实际项目中应该从数据库查询
        return new ResultJson(200, careDetails, "查询成功");
    }

    /**
     * 用户选择护理内容1页面
     * 用户传入json格式：
     * 服务1（one）：int
     * 服务次数1（one_count）：int
     * 传出json格式：
     * "选择成功"或"选择失败"
     */
    @PostMapping("/select-service1")
    public ResultJson selectService1(@RequestParam int one, @RequestParam int oneCount, @RequestParam String idCard) {
        boolean result = userCareDetailsService.selectCareService(1, null, oneCount, idCard);
        return result ? new ResultJson(200, "选择成功", "选择成功") : new ResultJson(500, "选择失败", "选择失败");
    }

    /**
     * 用户选择护理内容2页面
     * 用户传入json格式：
     * 服务2（two）：字符串
     * 服务次数2（two_count）：int
     * 传出json格式：
     * "选择成功"或"选择失败"
     */
    @PostMapping("/select-service2")
    public ResultJson selectService2(@RequestParam String two, @RequestParam int twoCount, @RequestParam String idCard) {
        boolean result = userCareDetailsService.selectCareService(2, two, twoCount, idCard);
        return result ? new ResultJson(200, "选择成功", "选择成功") : new ResultJson(500, "选择失败", "选择失败");
    }

    /**
     * 用户选择护理内容3页面
     * 用户传入json格式：
     * 服务3（three）：字符串
     * 服务次数3（three_count）：int
     * 传出json格式：
     * "选择成功"或"选择失败"
     */
    @PostMapping("/select-service3")
    public ResultJson selectService3(@RequestParam String three, @RequestParam int threeCount, @RequestParam String idCard) {
        boolean result = userCareDetailsService.selectCareService(3, three, threeCount, idCard);
        return result ? new ResultJson(200, "选择成功", "选择成功") : new ResultJson(500, "选择失败", "选择失败");
    }

    /**
     * 用户选择护理内容4页面
     * 用户传入json格式：
     * 服务4（four）：字符串
     * 服务次数4（four_count）：int
     * 传出json格式：
     * "选择成功"或"选择失败"
     */
    @PostMapping("/select-service4")
    public ResultJson selectService4(@RequestParam String four, @RequestParam int fourCount, @RequestParam String idCard) {
        boolean result = userCareDetailsService.selectCareService(4, four, fourCount, idCard);
        return result ? new ResultJson(200, "选择成功", "选择成功") : new ResultJson(500, "选择失败", "选择失败");
    }

    /**
     * 用户选择护理内容5页面
     * 用户传入json格式：
     * 服务5（five）：字符串
     * 服务次数5（five_count）：int
     * 传出json格式：
     * "选择成功"或"选择失败"
     */
    @PostMapping("/select-service5")
    public ResultJson selectService5(@RequestParam String five, @RequestParam int fiveCount, @RequestParam String idCard) {
        boolean result = userCareDetailsService.selectCareService(5, five, fiveCount, idCard);
        return result ? new ResultJson(200, "选择成功", "选择成功") : new ResultJson(500, "选择失败", "选择失败");
    }

    /**
     * 用户显示自己护理服务页面
     * 传出json格式：
     * 护理服务ID (care_id)
     * 护理服务(care_details) ：字符串
     * 护理状态（remaining_sessions）：（已完成/未完成）
     * 护理内容剩余次数（remaining_sessions）：int
     */
    @GetMapping("/my-services")
    public ResultJson getMyCareServices(@RequestParam String idCard) {
        List<UserCareDetails> userCareServices = userCareDetailsService.getUserCareServices(idCard);
        return new ResultJson(200, userCareServices, "查询成功");
    }
}