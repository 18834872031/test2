package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fu_lianxi implements Serializable {
    private int fu_id;
    private String fu_name;

    private String fu_phone;

    private String fu_dianhua;

    private String fu_chudate;

    private String fu_bumen;

    private String fu_job;

    private String fu_email;
}
