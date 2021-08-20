package com.example.demo.bean.exception.myException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author not_simple
 * @version 1.0
 * @date 2020/7/28 15:09
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Value("${error.msg:1}")
    private  String msg ;

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        Integer ext = (Integer) webRequest.getAttribute("ext", 0);
        if (StringUtils.isEmpty(ext)){
            errorAttributes.put("code",404);
            errorAttributes.put("msg",msg);
        }else {
            errorAttributes.put("code",ext);
            errorAttributes.put("msg","系统错误");
        }
        System.out.println(errorAttributes);
        return errorAttributes;
    }

//    @Override
//    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
//        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
//        Integer ext = (Integer) webRequest.getAttribute("ext", 0);
//        if (StringUtils.isEmpty(ext)){
//            errorAttributes.put("code",404);
//            errorAttributes.put("msg",msg);
//        }else {
//            errorAttributes.put("code",ext);
//            errorAttributes.put("msg","系统错误");
//        }
//        System.out.println(errorAttributes);
//        return errorAttributes;
//    }
}
