package com.fwf_bbs.forumcommon.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className CommonResult
 * @description 通用返回类
 * @auther wulongdog
 * @date 2022/10/3  17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    /**
     * 状态码
     */
    private long code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 封装好的数据
     */
    private T data;

    /**
     * 成功返回结果
     * @param data
     * @return CommonResult<T>
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * 成功返回结果
     * @param data
     * @param message
     * @return CommonResult<T>
     */
    public static <T> CommonResult<T> success(T data,String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     * 失败返回结果
     * @param code
     * @return CommonResult<T>
     */
    public static <T> CommonResult<T> failed(IErrorCode code) {
        return new CommonResult<T>(code.getCode(),code.getMessage(),null);
    }

    /**
     * 失败返回结果
     * @param code
     * @param message
     * @return CommonResult<T>
     */
    public static <T> CommonResult<T> failed(IErrorCode code,String message) {
        return new CommonResult<T>(code.getCode(),message,null);
    }

    /**
     * 失败返回结果
     * @param message
     * @return CommonResult<T>
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(),message,null);
    }

    /**
     * 失败返回结果
     * @return CommonResult<T>
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数检验失败返回结果
     * @return CommonResult<T>
     */
    public static <T> CommonResult<T> validateFailed() {return failed(ResultCode.VALIDATE_FAILED);}

    /**
     * 参数检验失败返回结果
     * @param message
     * @return CommonResult<T>
     */
    public static <T> CommonResult<T> validateFailed(String message) {return failed(ResultCode.VALIDATE_FAILED,message);}

    /**
     * 未登陆返回结果
     * @param data
     * @return  CommonResult<T>
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     * @param data
     * @return  CommonResult<T>
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
}
