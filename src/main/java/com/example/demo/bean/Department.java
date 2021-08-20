package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author not_simple
 * @version 1.0
 * @date 2020/7/21 17:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    //部门主键
    private Integer id;
    //部门名
    private String department;

    private String name;
}
