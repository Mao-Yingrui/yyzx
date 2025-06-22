package com.neutech.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
@Getter
@Setter
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 身份证号
     */
    @TableId("id_card")
    private String idCard;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 密码
     */
    private String password;

    /**
     * 出生日期
     */
    private LocalDate birthDate;

    /**
     * 家属电话
     */
    private String familyPhone;

    /**
     * 是否申请入住(0-否,1-是)
     */
    private String isIn;

    /**
     * 账户余额
     */
    private float balance;
}
