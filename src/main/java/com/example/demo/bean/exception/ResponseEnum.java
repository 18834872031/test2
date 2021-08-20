package com.example.demo.bean.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 *
 *
 * @author not_simple
 * @version 1.0
 * @date 2020/8/18 18:56
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum implements BusinessExceptionAssert{
    BAD_LICENCE_TYPE(7001,"Bad licence type."),
    LiCENCE_NOT_FOUND(7002,"Licence not found."),

    /**
     * 通用操作结果代码
     */
    FAIL(400, "失败"),
    SUCCESS(200, "成功"),
    SYSTEM_ERROR(405 , "系统数据异常"),
    REQUEST_PARAM_IS_ERROR(409 , "请求参数异常"),
    BIND_EEXCEPTION(4001 , "参数绑定异常"),
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION(4002 , "参数校验失败"),
    HANDLE_SERVLET_EXCEPTION(4003 , "Controller上一层相关异常"),
    HANDLE_BUSINESS_EXCEPTION(4004 , "业务异常")
    ;


    private int code;
    private String message;
}
