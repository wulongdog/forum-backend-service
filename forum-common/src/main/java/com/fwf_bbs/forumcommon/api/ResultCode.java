package com.fwf_bbs.forumcommon.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @className ResultCode
 * @description 常用api返回对象
 * @auther wulongdog
 * @date 2022/10/3  17:10
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ResultCode implements IErrorCode{

    SUCCESS(2000, "操作成功"),
    FAILED(5000, "操作失败"),
    VALIDATE_FAILED(4040, "参数检验失败"),
    UNAUTHORIZED(4010, "暂未登录或token已经过期"),
    FORBIDDEN(4030, "没有相关权限");

    private long code;

    private String message;


    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
