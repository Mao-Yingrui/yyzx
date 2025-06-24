package com.neutech.entity;

import lombok.Data;

@Data
public class UserNursingLevel {
    private String idCard;          // 身份证号
    private String nursingLevel;    // 护理级别：无依赖/轻度依赖/中度依赖/重度依赖/无级别
}