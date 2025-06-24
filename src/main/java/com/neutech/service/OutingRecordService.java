package com.neutech.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neutech.entity.OutingRecord;

import java.util.List;


public interface OutingRecordService extends IService<OutingRecord> {

    List<OutingRecord> getAllApplications();


    boolean approveApplication(String userId);


    List<OutingRecord> getApprovedOutings();


    boolean registerReturn(String userId);

    boolean updateApplication(String userId, String name, String outingTime,
                               String outingReason, String destination);

    boolean deleteApplicationById(Integer outingId);
}