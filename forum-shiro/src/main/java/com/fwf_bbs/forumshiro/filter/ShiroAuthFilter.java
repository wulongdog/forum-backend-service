package com.fwf_bbs.forumshiro.filter;

import com.fwf_bbs.forumshiro.entity.ShiroAuthToken;
import com.fwf_bbs.forumshiro.utils.JwtTokenUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @className shiroAuthFilter
 * @description shiro拦截器, 拦截token
 * @auther wulongdog
 * @date 2022/10/4  14:30
 */
public class ShiroAuthFilter extends BasicHttpAuthenticationFilter {

    /**
     * 存储token的header
     */
    protected static final String AUTHORIZATION_HEADER = "Authorization";
    /**
     * Token 的开头部分
     */
    protected static final String BEARER = "Bearer ";

    private String token;

    /**
     * 验证是否有token
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }


    /**
     * 验证是否有token
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        if(getAuthzHeader(request)!=null && !JwtTokenUtil.isTokenExpired(this.token)){
            //是否要去鉴权
            SecurityUtils.getSubject().login(new ShiroAuthToken(getAuthzHeader(request)));
            return true;
        }

        return false;
    }

    /**
     * 获取token
     * @param request
     * @return
     */
    @Override
    protected String getAuthzHeader(ServletRequest request) {
        try {
            HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
            this.token = httpServletRequest.getHeader(AUTHORIZATION_HEADER).substring(BEARER.length());
            return this.token;
        }catch (Exception e) {
            return null;
        }
    }


}
