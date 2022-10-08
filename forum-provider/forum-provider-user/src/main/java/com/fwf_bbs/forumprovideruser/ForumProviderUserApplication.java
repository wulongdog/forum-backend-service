package com.fwf_bbs.forumprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.fwf_bbs")
@EnableHystrix
@EnableDiscoveryClient
@EnableTransactionManagement
public class ForumProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumProviderUserApplication.class, args);
    }

}
