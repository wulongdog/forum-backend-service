package com.fwf_bbs.forumgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableDiscoveryClient
@EnableZuulProxy
@EnableSwagger2
@EnableWebMvc
@SpringBootApplication
public class ForumGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForumGatewayApplication.class, args);
    }

}
