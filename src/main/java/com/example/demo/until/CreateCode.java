package com.example.demo.until;

import java.util.UUID;

/**
 * @author 残殇
 * #Description CreateCode
 * #Date: 2021/7/27 19:14
 */
public class CreateCode {
    public static int create() {
        int i = UUID.randomUUID().hashCode();
        if (i < 0) {
            i *= -1;
        }
        i = (int) (i + Math.round(Math.random() * 3000));
        return i;
    }
}
