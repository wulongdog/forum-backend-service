package com.fwf_bbs.forumproviderdemoapi.service;

import com.fwf_bbs.forumcommon.api.CommonResult;
import com.fwf_bbs.forumproviderdemoapi.service.hystrix.DemoFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className DemoFeginApi
 * @description demo api
 * @auther wulongdog
 * @date 2022/10/7  22:14
 */
@FeignClient(value = "forum-provider-demo",fallback = DemoFeignHystrix.class)
@Component
@Service
public interface DemoFeignApi {

    @RequestMapping("/demo/Feigntest")
    public CommonResult<String> getDemo();

    @RequestMapping("/note/getFeign")
    public CommonResult<Object> getNote();
}
