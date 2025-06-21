package com.neutech.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Morrien
 * @since 2025-06-20
 */
@Data
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String name;

    private String gender;

    private String idCard;

    private String password;

    private LocalDate birthDate;

    private String familyPhone;

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFamilyPhone() {
        return familyPhone;
    }
}
