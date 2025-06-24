package com.neutech.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("bed")
public class Bed {
    @TableId(value = "bed_id", type = IdType.AUTO)
    private Integer bedId;

    private String location;

    private String status;

    private String userId;

    public Integer getBedId() {
        return bedId;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public String getUserId() {
        return userId;
    }
}