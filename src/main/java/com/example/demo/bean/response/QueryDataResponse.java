package com.example.demo.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author not_simple
 * @version 1.0
 * @date 2020/7/28 13:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryDataResponse<T> {

    //状态码
    private int code;

    //响应信息
    private String message;

    //响应数据
    private T data;

    public QueryDataResponse(int code , String message){
        this.code = code;
        this.message = message;
    }

}
