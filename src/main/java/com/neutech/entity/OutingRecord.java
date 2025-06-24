package com.neutech.entity;

import lombok.Data;

/**
 * 外出记录实体类
 */
@Data
public class OutingRecord {
    private Integer outingId; // 外出记录ID
    private String userId; // 用户身份证号
    private String name; // 用户姓名
    private String outingTime; // 外出时间
    private String outingReason; // 外出原因
    private String destination; // 目的地
    private String backTime; // 返回时间
    private String outState; // 外出状态
}