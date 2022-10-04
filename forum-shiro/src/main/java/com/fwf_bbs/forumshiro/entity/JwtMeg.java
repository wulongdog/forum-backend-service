package com.fwf_bbs.forumshiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @className JwtMeg
 * @description jwt 信息
 * @auther wulongdog
 * @date 2022/10/4  12:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtMeg {

    private String iss;

    private Date iat;

    private Long uid;

    private Integer urole;
}
