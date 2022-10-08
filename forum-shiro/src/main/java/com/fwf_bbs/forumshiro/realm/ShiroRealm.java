package com.fwf_bbs.forumshiro.realm;

import com.fwf_bbs.forumshiro.entity.JwtMeg;
import com.fwf_bbs.forumshiro.entity.ShiroAuthToken;
import com.fwf_bbs.forumshiro.utils.JwtTokenUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @className DemoRealm
 * @description demo 的realm类
 * @auther wulongdog
 * @date 2022/10/4  14:08
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    public ShiroRealm(CredentialsMatcher matcher) {
        super(matcher);
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof ShiroAuthToken;
    }

    /**
     * 给shiro 用户已经响应的操作权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        JwtMeg jwtMeg = JwtTokenUtil.getJwtMeg(principalCollection.toString());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //设置用户
        if(jwtMeg.getUid()!=null) {
            info.addRole("user");
        }
        //如有需要在这设置操作权限

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        ShiroAuthToken shiroAuthToken = (ShiroAuthToken) authenticationToken;

        String token = (String) shiroAuthToken.getCredentials();

        if(JwtTokenUtil.isTokenExpired(token)){
            throw new AuthenticationException("token已经失效!");
        }

        return new SimpleAuthenticationInfo(token,token,"DemoRealm");
    }
}
