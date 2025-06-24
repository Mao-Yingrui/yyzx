package com.neutech.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neutech.entity.OutingRecord;
import com.neutech.mapper.OutingRecordMapper;
import com.neutech.service.OutingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 外出记录服务实现类
 */
@Service
public class OutingRecordServiceImpl extends ServiceImpl<OutingRecordMapper, OutingRecord> implements OutingRecordService {
    @Autowired
    private OutingRecordMapper outingRecordMapper;

    /**
     * 获取所有申请信息
     * @return 申请信息列表
     */
    @Override
    public List<OutingRecord> getAllApplications() {
        return outingRecordMapper.getAllApplications();
    }

    /**
     * 审核用户申请
     * @param userId 用户身份证号
     * @return 操作结果
     */
    @Override
    public boolean approveApplication(String userId) {
        return outingRecordMapper.approveApplication(userId) > 0;
    }

    /**
     * 获取已通过的外出用户信息
     * @return 外出用户信息列表
     */
    @Override
    public List<OutingRecord> getApprovedOutings() {
        return outingRecordMapper.getApprovedOutings();
    }

    /**
     * 外出回归登记
     * @param userId 用户身份证号
     * @return 操作结果
     */
    @Override
    public boolean registerReturn(String userId) {
        return outingRecordMapper.registerReturn(userId) > 0;
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
    @Override
    public boolean updateApplication(String userId, String name, String outingTime,
                                     String outingReason, String destination) {
        return outingRecordMapper.updateApplication(userId, name, outingTime, outingReason, destination) > 0;
    }

    /**
     * 删除用户申请信息
     * @param outingId 外出记录ID
     * @return 操作结果
     */
    @Override
    public boolean deleteApplicationById(Integer outingId) {
        return outingRecordMapper.deleteApplicationById(outingId) > 0;
    }
}