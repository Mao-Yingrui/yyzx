package com.neutech.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("health_assignment")
public class HealthAssignment {
    @TableId(value = "assignment_id", type = IdType.AUTO)
    private Integer assignmentId;

    private Integer healthHomeId;

    private String userId;
}