package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author not_simple
 * @date 2020/7/21 17:33
 * 员工部门
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    //主键
    private Integer id;
    //名字
    private String lastName;
    //邮箱
    private String email;
    //性别
    private Integer gender;
    //部门id主键
    private Integer dId;

    private String name;
}
