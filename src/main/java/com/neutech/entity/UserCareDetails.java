package com.neutech.entity;

import lombok.Data;

@Data
public class UserCareDetails {
    private String idCard;          // 身份证号
    private Integer careId;         // 护理服务ID
    private String remainingSessions; // 护理状态：已完成/未完成
    private Integer remainingCount; // 护理内容剩余次数
    private String careDetails;     // 护理服务详情(用于显示)
}