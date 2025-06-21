package com.neutech.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


@Data
@TableName("user")
public class User {

    @TableId("id_card")
    private String idCard;

    private String name;

    private String gender;

    private String password;

    private String birthDate;

    private String familyPhone;

    @TableField("is_in")
    private Integer isIn;

    private Float balance;
}
