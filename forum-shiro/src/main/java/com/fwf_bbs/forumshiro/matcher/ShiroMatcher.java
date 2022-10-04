package com.fwf_bbs.forumshiro.matcher;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * @className ShiroMatcher
 * @description shiro 实现matcher类
 * @auther wulongdog
 * @date 2022/10/4  16:47
 */
public class ShiroMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        
        return true;
    }
}
