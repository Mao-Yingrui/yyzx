package com.neutech.entity;

import lombok.Data;

@Data
public class UserCareServiceVO {
    private Integer careId;         // 护理服务ID
    private String careDetails;     // 护理服务详情
    private Integer remainingCount; // 护理内容剩余次数
}