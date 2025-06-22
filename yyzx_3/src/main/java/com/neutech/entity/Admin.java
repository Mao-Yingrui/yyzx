package com.neutech.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Morrien
 * @since 2025-06-21
 */
@Data
public class Admin implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId("ad_id")
    private String adId;

    private String adName;

    private String adPwd;
}
