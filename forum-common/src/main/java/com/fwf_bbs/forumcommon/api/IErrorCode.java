package com.fwf_bbs.forumcommon.api;

/**
 * @className IErrorCode
 * @description 常用api返回对象接口
 * @auther wulongdog
 * @date 2022/10/3  17:09
 */
public interface IErrorCode {

    /**
     * 获取状态码
     * @return
     */
    long getCode();

    /**
     * 获取信息
     * @return
     */
    String getMessage();

}
