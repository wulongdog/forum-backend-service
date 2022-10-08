package com.fwf_bbs.forumprovideruser.web.controller;

import com.fwf_bbs.forumcommon.api.CommonResult;
import com.fwf_bbs.forumproviderdemoapi.service.DemoFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @className TestController
 * @description 试试调用demo的feign
 * @auther wulongdog
 * @date 2022/10/8  10:19
 */
@RestController
@RequestMapping("/user")
public class TestController {

    @Autowired
    private DemoFeignApi demoFeign;

    @RequestMapping("/test")
    public CommonResult<String> test() {
        return demoFeign.getDemo();
    }

    @RequestMapping("/get")
    public CommonResult<Object> get() {
        return CommonResult.success(demoFeign.getNote());
    }
}
