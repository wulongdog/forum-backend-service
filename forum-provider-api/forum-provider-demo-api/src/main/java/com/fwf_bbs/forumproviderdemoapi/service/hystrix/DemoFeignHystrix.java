package com.fwf_bbs.forumproviderdemoapi.service.hystrix;

import com.fwf_bbs.forumcommon.api.CommonResult;
import com.fwf_bbs.forumproviderdemoapi.service.DemoFeignApi;
import org.springframework.stereotype.Component;

/**
 * @className DemoFeignHystrix
 * @description demo 的服务降级类
 * @auther wulongdog
 * @date 2022/10/7  22:17
 */
@Component
public class DemoFeignHystrix implements DemoFeignApi {
    @Override
    public CommonResult<String> getDemo() {
        return CommonResult.failed("服务中断");
    }

    @Override
    public CommonResult<Object> getNote() {
        return CommonResult.failed("服务中断");
    }
}
