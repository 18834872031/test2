package com.example.demo.errorHandler;


import com.example.demo.bean.exception.BusinessException;
import com.example.demo.bean.exception.ResponseEnum;
import com.example.demo.bean.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author not_simple
 * @version 1.0
 * @date 2020/8/18 19:18
 */

@Slf4j
@ControllerAdvice
public class UnifiedExceptionHandler {

    /**
     * 生成环境
     */
    private final static  String ENV_PROD = "prod";

    /*
     * 当前环境
     */
//    @Value("${spring.profiles.active}")
    private String profile;


    /**
     *   业务异常  自定义
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ErrorResponse handleBusinessException(BusinessException e, HttpServletRequest request){
        log.error("业务异常  自定义");
        log.error(e.getMessage(),e);
        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如数据库异常信息.
            return new ErrorResponse(ResponseEnum.HANDLE_BUSINESS_EXCEPTION);
        }
        return new ErrorResponse(e.getCode(),e.getMessage());
    }

    /**
     * Controller上一层相关异常
     *
     * @param e 异常
     * @return 异常结果
     */

    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            // BindException.class,
            // MethodArgumentNotValidException.class
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    @ResponseBody
    public ErrorResponse handleServletException(Exception e){
        log.error("参数绑定校验异常");
        log.error(e.getMessage(),e);
        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如数据库异常信息.
            return new ErrorResponse(ResponseEnum.HANDLE_SERVLET_EXCEPTION);
        }
        return new ErrorResponse(ResponseEnum.HANDLE_SERVLET_EXCEPTION.getCode(),e.getMessage());
    }


    /**
     * 参数绑定异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ErrorResponse handleBindException(BindException e) {
        log.error("参数绑定异常");
        log.error(e.getMessage(), e);
        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如数据库异常信息.
            return new ErrorResponse(ResponseEnum.BIND_EEXCEPTION);
        }
        return new ErrorResponse(ResponseEnum.BIND_EEXCEPTION.getCode(),e.getMessage());
    }

    /**
     * 参数校验异常，将校验失败的所有异常组合成一条错误信息
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse handleValidException(MethodArgumentNotValidException e) {
        log.error("参数校验异常");
        log.error(e.getMessage(), e);
        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如数据库异常信息.
            return new ErrorResponse(ResponseEnum.METHOD_ARGUMENT_NOT_VALID_EXCEPTION);
        }
        return new ErrorResponse(ResponseEnum.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.getCode(),e.getMessage());
    }




    /**
     * 未定义异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorResponse handleException(Exception e) {
        log.error("未定义异常");
        log.error(e.getMessage(), e);
        if (ENV_PROD.equals(profile)) {
            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如数据库异常信息.
            return new ErrorResponse(ResponseEnum.SYSTEM_ERROR);
        }
        return new ErrorResponse(ResponseEnum.SYSTEM_ERROR.getCode(),e.getMessage());
    }
}
