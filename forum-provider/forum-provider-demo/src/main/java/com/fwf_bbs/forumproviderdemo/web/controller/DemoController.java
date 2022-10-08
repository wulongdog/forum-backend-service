package com.fwf_bbs.forumproviderdemo.web.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className DemoController
 * @description demo controller类 对外接口
 * @auther wulongdog
 * @date 2022/10/7  22:22
 */
@RestController
@RequestMapping("/demo")
@Api
public class DemoController {

    @RequestMapping("/test")
    public String demoTest(){
        return "hello world";
    }
}
