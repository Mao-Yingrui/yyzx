package com.neutech.entity;

import lombok.Data;

@Data
public class CareContent {
    private Integer careId;          // 护理服务ID (主键)
    private String nursingLevel;     // 护理级别（无依赖/轻度依赖/中度依赖/重度依赖/无级别）
    private String caregiverName;    // 护工姓名
    private String careDetails;      // 护理服务详情
    private Double carePrice;        // 护理单价
}