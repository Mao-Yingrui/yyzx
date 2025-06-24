package com.neutech.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neutech.entity.CheckoutRecord;

import java.util.List;
import java.util.Map;

public interface CheckoutRecordService extends IService<CheckoutRecord> {
    List<Map<String, Object>> getCheckoutApplications();
    boolean approveApplication(String user_id);
    boolean rejectApplication(String user_id);
     /**
     * 更新退住申请
     * @param user_id 用户ID
     * @param bed_id 床位ID
     * @param checkout_time 退住时间
     * @return 操作是否成功
     */
    boolean updateApplication(String user_id, int bed_id, java.time.LocalDateTime checkout_time);
    boolean deleteApplication(String user_id);
}