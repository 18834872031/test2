package com.example.demo.bean.exception;


/**
 *
 * 自定义业务异常  继承BaseException
 *     让ExceptionHandler能够捕获到抛出的是 BusinessException 自定义业务异常
 *
 * @author not_simple
 * @version 1.0
 * @date 2020/8/18 18:46
 */

public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(int code ,String message) {
        super(code,message);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args) {
        super(responseEnum, args);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum, args, cause);
    }
}
