package com.neutech.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("record")
public class Record {
    @TableId("record_id")
    private Integer recordId;

    @TableField("user_id")
    private String userId;

    private String time;
}