package com.neutech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neutech.entity.CheckoutRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CheckoutRecordMapper extends BaseMapper<CheckoutRecord> {
    List<Map<String, Object>> getCheckoutApplications();
    
    /**
     * 根据用户ID查询退住申请
     */
    List<Map<String, Object>> getCheckoutApplicationsByUserId(String user_id);
    
    /**
     * 更新床位状态为空闲，并将user_id设置为NULL
     */
    boolean updateBedStatus(int bed_id);

    boolean approveApplication(String user_id);
    boolean rejectApplication(String user_id);
    boolean updateApplication(String user_id, int bed_id);
    
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