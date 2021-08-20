package com.example.demo.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author not_simple
 * @version 1.0
 * @date 2020/8/18 19:45
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResopnse {
    int code;
    String message;
}
