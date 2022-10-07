package com.fwf_bbs.forumproviderdemo.web.rpc;

import com.fwf_bbs.forumcommon.api.CommonResult;
import com.fwf_bbs.forumproviderdemoapi.service.DemoFeignApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className DemoFeignClient
 * @description 微服务调用接口
 * @auther wulongdog
 * @date 2022/10/7  22:22
 */
@RestController
@Api
public class DemoFeignClient implements DemoFeignApi {

    @Override
    @ApiOperation("DemoFeign")
    public CommonResult<String> getDemo() {
        return null;
    }
}
