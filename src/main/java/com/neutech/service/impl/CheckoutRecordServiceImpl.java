package com.neutech.service.impl;

import com.neutech.entity.CheckoutRecord;
import com.neutech.mapper.CheckoutRecordMapper;
import com.neutech.service.CheckoutRecordService;
import com.neutech.service.HealthAssignmentAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CheckoutRecordServiceImpl extends ServiceImpl<CheckoutRecordMapper, CheckoutRecord> implements CheckoutRecordService {

    @Autowired
    private CheckoutRecordMapper checkoutRecordMapper;

    @Autowired
    private HealthAssignmentAdminService healthAssignmentAdminService;

    @Override
    public List<Map<String, Object>> getCheckoutApplications() {
        return checkoutRecordMapper.getCheckoutApplications();
    }

    @Override
    public boolean approveApplication(String user_id) {
        // 更新退住记录状态
        boolean result = checkoutRecordMapper.approveApplication(user_id);

        // 获取关联的床位ID
        List<Map<String, Object>> records = checkoutRecordMapper.getCheckoutApplicationsByUserId(user_id);
        if (!records.isEmpty()) {
            Map<String, Object> record = records.get(0);
            Integer bed_id = (Integer) record.get("bed_id");

            // 更新床位状态和user_id
            if (bed_id != null) {
                checkoutRecordMapper.updateBedStatus(bed_id);
            }
        }

        // 删除健康分配记录
        healthAssignmentAdminService.deleteHealthAssignmentsByUserId(user_id);

        return result;
    }

    @Override
    public boolean rejectApplication(String user_id) {
        return checkoutRecordMapper.rejectApplication(user_id);
    }



    @Override
    public boolean updateApplication(String user_id, int bed_id, java.time.LocalDateTime checkout_time) {
        return checkoutRecordMapper.updateApplication(user_id, bed_id, checkout_time);
    }

    @Override
    public boolean deleteApplication(String user_id) {
        // 查询是否有关联的退住申请
        List<Map<String, Object>> records = checkoutRecordMapper.getCheckoutApplicationsByUserId(user_id);

        if (records.isEmpty()) {
            return false; // 无待删除的申请
        }

        // 获取关联的床位ID
        Map<String, Object> record = records.get(0);
        Integer bed_id = (Integer) record.get("bed_id");

        // 开始事务处理
        try {
            // 删除申请
            boolean result = checkoutRecordMapper.deleteApplication(user_id);

            if (!result) {
                throw new RuntimeException("Failed to delete checkout application");
            }

            // 如果存在关联床位，更新床位状态
            if (bed_id != null) {
                // 将床位状态更新为"空闲"
                checkoutRecordMapper.updateBedStatus(bed_id);
            }

            // 发送通知给申请人
            sendNotificationToApplicant(user_id, "您的退住申请已被取消");

            // 提交事务
            return true;
        } catch (Exception e) {
            // 回滚事务
            // 可以在这里添加日志记录
            // rollback logic if needed based on your transaction management

            // 发送错误通知
            sendNotificationToApplicant(user_id, "删除退住申请时发生错误: " + e.getMessage());

            return false;
        }
    }

    /**
     * 发送通知给申请人
     * @param user_id 用户ID
     * @param message 通知内容
     */
    private void sendNotificationToApplicant(String user_id, String message) {
        // 这里可以实现具体的通知发送逻辑
        // 比如邮件通知、短信通知或站内信等
        System.out.println("发送通知给用户 " + user_id + ": " + message);
    }
}