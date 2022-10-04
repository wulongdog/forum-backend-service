package com.fwf_bbs.forumdemo.config;

import com.fwf_bbs.forumcommon.config.BaseSwaggerConfig;
import com.fwf_bbs.forumcommon.entity.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @className SwaggerConfig
 * @description swagger api文档配置
 * @auther wulongdog
 * @date 2022/10/3  23:04
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.fwf_bbs.forumdemo.controller")
                .title("forum test demo")
                .description("forumdemo相关接口文档")
                .contactName("fwf_bbs")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }
}
