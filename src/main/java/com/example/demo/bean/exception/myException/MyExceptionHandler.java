package com.example.demo.bean.exception.myException;



import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author not_simple
 * @version 1.0
 * @date 2020/7/27 17:58
 */
//@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MyException.class)
    public String handleException(Exception e, HttpServletRequest request){
        e.printStackTrace();
        Map<String,Object> map =new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code",400);
        map.put("msg","自定义错误");
        request.setAttribute("ext",100);
        return "forward:/error";
    }




    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String,Object> handleExceptionAll(Exception e){
        e.printStackTrace();
        Map<String,Object> map =new HashMap<>();
        System.out.println(e.getMessage());
        map.put("code",400);
        map.put("msg","所有错误");
        return map;
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
    public Map<String,Object> handleServletException(Exception e){
        e.printStackTrace();
        System.out.println(e.getMessage());
        Map<String,Object> map =new HashMap<>();
        map.put("code",400);
        map.put("msg", e.getMessage());
        return map;
    }

    @InitBinder("de")
    public void de (WebDataBinder binder){
        //@ModelAttribute 标注的的参数前缀加上 de.
        binder.setFieldDefaultPrefix("de.");
    }
    @InitBinder("e")
    public void e (WebDataBinder binder){
        //@ModelAttribute 标注的的参数前缀加上 de.
        binder.setFieldDefaultPrefix("e.");
    }
}
