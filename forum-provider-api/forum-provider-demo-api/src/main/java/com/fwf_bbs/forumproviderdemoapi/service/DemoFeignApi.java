package com.fwf_bbs.forumproviderdemoapi.service;

import com.fwf_bbs.forumcommon.api.CommonResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className DemoFeginApi
 * @description demo api
 * @auther wulongdog
 * @date 2022/10/7  22:14
 */
@FeignClient(value = "forum-provider-demo")
public interface DemoFeignApi {

    @RequestMapping("/demo/test")
    public CommonResult<String> getDemo();
}
