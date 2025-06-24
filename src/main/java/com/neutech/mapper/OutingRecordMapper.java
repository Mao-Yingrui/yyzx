package com.neutech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neutech.entity.OutingRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface OutingRecordMapper extends BaseMapper<OutingRecord> {

    List<OutingRecord> getAllApplications();


    int approveApplication(@Param("userId") String userId);
    List<OutingRecord> getApprovedOutings();

    int registerReturn(@Param("userId") String userId);


    int updateApplication(@Param("id") String id, 
                         @Param("status") String status, 
                         @Param("reason") String reason, 
                         @Param("approver") String approver, 
                         @Param("applicationTime") String applicationTime);

    int deleteApplicationById(@Param("outingId") Integer outingId);
}