package com.neutech.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@TableName("user")
public class User {

    @TableId("id_card")
    private String idCard;

    private String name;

    private String gender;

    private String password;

    private LocalDate birthDate;

    private String familyPhone;

    @TableField("is_in")
    private String isIn;

    private float balance;

//    // 显式添加 getter 方法
//    public String getIdCard() {
//        return idCard;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public String getFamilyPhone() {
//        return familyPhone;
//    }
//
//    public String getIsIn() {
//        return isIn;
//    }
//
//    public float getBalance() {
//        return balance;
//    }


}