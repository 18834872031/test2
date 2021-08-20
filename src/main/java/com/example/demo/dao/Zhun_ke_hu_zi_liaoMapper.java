package com.example.demo.dao;

import com.example.demo.entity.Bendi;
import com.example.demo.entity.Zhun_ke_hu_zi_liao;

import java.util.List;

public interface Zhun_ke_hu_zi_liaoMapper {
    List<Zhun_ke_hu_zi_liao> selectList(Zhun_ke_hu_zi_liao zhun_ke_hu_zi_liao);
    List<Zhun_ke_hu_zi_liao> selectList1(Zhun_ke_hu_zi_liao zhun_ke_hu_zi_liao);
    List<Bendi> selectListk(Bendi bendi);
    List<Bendi> selectListk6();
    void addZhun(Zhun_ke_hu_zi_liao zhun_ke_hu_zi_liao);
    int deleteByPrimaryKey(int id);
    int updateZhun(Bendi bendi);
    void deletepi(String[] split);


    int insert(Zhun_ke_hu_zi_liao record);

    int insertSelective(Zhun_ke_hu_zi_liao record);

    List<Object> selectById(int id);
    List<Bendi> selectById2(int id);
    Bendi selectById3(int id);
    int updateByPrimaryKeySelective(Zhun_ke_hu_zi_liao record);
}