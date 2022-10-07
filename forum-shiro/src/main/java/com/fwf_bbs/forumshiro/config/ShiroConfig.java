package com.fwf_bbs.forumshiro.config;

import com.fwf_bbs.forumshiro.filter.ShiroAuthFilter;
import com.fwf_bbs.forumshiro.matcher.ShiroMatcher;
import com.fwf_bbs.forumshiro.realm.ShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @className ShiroConfig
 * @description shiro配置类
 * @auther wulongdog
 * @date 2022/10/4  14:05
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建自定义realm
     * @return
     */
    @Bean(name="ShiroRealm")
    public ShiroRealm getRealm(){
        return new ShiroRealm(new ShiroMatcher());
    }

    /**
     * shiro过滤器工厂
     * @param securityManager
     * @return
     */
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean =new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, Filter> filters = new HashMap<>(2);
        //  添加 shiroAuthFilter 的拦截器，不要使用 Spring 来管理 Bean
        filters.put("authFilter", new ShiroAuthFilter());
        shiroFilterFactoryBean.setFilters(filters);
        // 一定要用 LinkedHashMap，HashMap 顺序不一定按照 put 的顺序，拦截匹配规则是从上往下的
        // 比如 /api/user/login ，已经匹配到了，即使用 anon 的拦截器，就不会再去匹配 /** 了
        // anon 支持匿名访问的拦截器
        LinkedHashMap<String, String> filterChainDefinitions = new LinkedHashMap<>(4);
        /*
         * 添加shiro内置过滤器，实现权限相关的url拦截
         * 常见过滤器：
         * anon：无需认证（登录）可以访问
         * authc：必须认证才可以访问
         * user:如果使用Remember Me的功能，可以直接访问
         * perms:该资源必须得到资源权限才可以访问
         * role:该资源必须得到角色权限才可以访问
         */
        // 登录接口和注册放开
        filterChainDefinitions.put("/api/user/login", "anon");
        filterChainDefinitions.put("/api/user/register", "anon");
        filterChainDefinitions.put("/note/test", "anon");
        filterChainDefinitions.put("/**", "authFilter");
        // 后序有哪些在写

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitions);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建 DefaultWebSecurityManager
//     * @param shiroRealm
     * @return
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getdefaultDefaultWebSecurityManager(/*@Qualifier("ShiroRealm") ShiroRealm shiroRealm*/){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(getRealm());
        return securityManager;
    }



    /**
     * 权限操作aop
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator proxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setUsePrefix(true);
        return proxyCreator;
    }


}
