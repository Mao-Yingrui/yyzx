package com.neutech.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("checkout_record")
public class CheckoutRecord {
    @TableId(value = "checkout_id", type = IdType.AUTO)
    private Long checkoutId;

    @TableField("user_id")
    private String user_id;

    @TableField("bed_id")
    private Integer bed_id;

    @TableField("checkout_time")
    private java.time.LocalDateTime checkout_time;

    @TableField("status")
    private String status;
}