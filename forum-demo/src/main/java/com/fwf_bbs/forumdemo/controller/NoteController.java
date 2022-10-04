package com.fwf_bbs.forumdemo.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-10-03
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    @ApiOperation("demo测试")
    @RequestMapping("/test1")
    public String test1() {
        return "hello world";
    }


    @RequiresRoles("user")//角色控制
    @RequiresPermissions("update")//操作控制
    @ApiOperation("demo测试")
    @RequestMapping("/test2")
    public String test2() {
        return "hello world";
    }
}
