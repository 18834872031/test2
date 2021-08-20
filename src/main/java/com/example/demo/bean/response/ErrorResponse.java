package com.example.demo.bean.response;


import com.example.demo.bean.exception.ResponseEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author not_simple
 * @version 1.0
 * @date 2020/8/18 19:44
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse{
    private static final long serialVersionUID = 1L;

    int code;
    String message;


    public ErrorResponse(ResponseEnum responseEnum){
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }


}