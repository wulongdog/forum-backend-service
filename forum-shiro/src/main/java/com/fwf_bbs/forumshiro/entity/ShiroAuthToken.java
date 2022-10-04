package com.fwf_bbs.forumshiro.entity;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @className ShiroAuthToken
 * @description 自定义authenticationToken
 * @auther wulongdog
 * @date 2022/10/4  14:21
 */
public class ShiroAuthToken implements AuthenticationToken {

    private String token;

    public ShiroAuthToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
