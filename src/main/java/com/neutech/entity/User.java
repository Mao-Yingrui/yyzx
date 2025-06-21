package com.neutech.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


@Data//Lombok 提供的注解，自动生成 getter/setter/toString 等方法。
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
    private Integer isIn;//当 Java 属性名和数据库字段名不一样时使用。

    private Float balance;
}
