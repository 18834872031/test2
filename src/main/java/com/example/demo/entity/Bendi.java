package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bendi implements Serializable {
    private int id;

    private String name;
    private String yixiang;

    private String leixing;
    private  String hangye;
    private String xingzi;

    private String haoma;

    private String mansum;

    private String tousum;

    private String province;

    private String city;

    private String county;

    private String address;

    private String zhuname;

    private String phone;

    private String dianhua;

    private String chudate;

    private String bumen;

    private String job;

    private String email;

    private Fu_lianxi fu_lianxi;
}
