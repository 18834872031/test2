package com.example.demo.controller;

import com.example.demo.dao.Zhun_ke_hu_zi_liaoMapper;
import com.example.demo.entity.Bendi;
import com.example.demo.entity.Zhun_ke_hu_zi_liao;
import com.example.demo.until.MyExpecion;
import com.example.demo.until.RedisUtil;
import com.example.demo.until.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin

public class ZhunController {
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private Zhun_ke_hu_zi_liaoMapper zhun_ke_hu_zi_liaoMapper;
    /**
     * 获取对应键的值，redisTemplate操作
     * @param key
     * @return
     */
    @RequestMapping(value = "get")
    public Object getValue(String key){
        Object value = redisTemplate.opsForValue().get(key);
        return value;
    }

    /**
     * 添加键值
     * @param key
     * @param value
     * @return
     */
    @RequestMapping(value = "set")
    public boolean set(String key, String value){
        return redisUtil.set(key, value);
    }

    @RequestMapping("/zhun4")
    public List<Bendi>  tjjdddf() {
        String key = "bendiList";
        ListOperations<String, Bendi> operations = redisTemplate.opsForList();
        if (redisTemplate.hasKey(key)) {
            return operations.range(key, 0, -1);
        } else {
            List<Bendi> bendis = zhun_ke_hu_zi_liaoMapper.selectListk6();
            operations.leftPushAll(key, bendis);
            return bendis;
        }
    }
    /**
     * 获取全部数据
     * @return
     */
//    @RequestMapping(value = "getList")
//    public Object getList(){
//
//    }


    @RequestMapping("/zhun")
    public List<Zhun_ke_hu_zi_liao> tjhj(@RequestBody Zhun_ke_hu_zi_liao zhun_ke_hu_zi_liao) {
        String key = "ZhunList";
        ListOperations<String, Zhun_ke_hu_zi_liao> operations = redisTemplate.opsForList();
        if (redisTemplate.hasKey(key)) {
            return operations.range(key, 0, -1);
        } else {
            List<Zhun_ke_hu_zi_liao> zhunList = zhun_ke_hu_zi_liaoMapper.selectList(zhun_ke_hu_zi_liao);
            operations.leftPushAll(key, zhunList);
            return zhunList;
        }
    }

//    @RequestMapping("/zhun1")
//    public ResultJson<List<Zhun_ke_hu_zi_liao>> tjmhj()throws MyExpecion {
//        ResultJson resultJson=new ResultJson();
//        List<Zhun_ke_hu_zi_liao> zhunList =zhun_ke_hu_zi_liaoMapper.selectList1();
//        if (zhunList.size()>0){
//            resultJson.setCode(200);
//            resultJson.setMessage("成了");
//            resultJson.setSuccess(true);
//            resultJson.setData(zhunList);
//            return resultJson;
//        }else {
//            throw new MyExpecion(true,500,"shibai");
//        }
//    }
@RequestMapping("/zhun1")
public Object tjmhj(@RequestBody Zhun_ke_hu_zi_liao zhun_ke_hu_zi_liao) {
    String key = "Zhun1List";
    ListOperations<String, Zhun_ke_hu_zi_liao> operations = redisTemplate.opsForList();
    if (redisTemplate.hasKey(key)) {
        return operations.range(key, 0, -1);
    } else {
        List<Zhun_ke_hu_zi_liao> zhunList1 = zhun_ke_hu_zi_liaoMapper.selectList1(zhun_ke_hu_zi_liao);
        operations.leftPushAll(key, zhunList1);
        return zhunList1;
    }
}
//    @RequestMapping("/zhunk6")
//    public ResultJson  tjwjdf( Bendi bendi) {
//        System.out.println(bendi);
//        List<Object> bendis =zhun_ke_hu_zi_liaoMapper.selectListk(bendi);
//
//        return ResultJson.ok().data("bendis", bendis);
//    }
//
//    @RequestMapping("/zhunk7")
//    public ResultJson dkdfdf1(@RequestBody int id){
//        System.out.println(id);
////        int id=0;
////        String[] array= new String[1];
////        array=dfhdfh.split("=");
////        for(String a :array){
////            id=Integer.parseInt(a);
////        }
////        System.out.println(id);
//        Bendi bendi = zhun_ke_hu_zi_liaoMapper.selectById3(id);
//        System.out.println(bendi);
//        if (bendi!=null){
//            return ResultJson.ok().data("ok",bendi);
//        }else {
//            return ResultJson.error().data("err",bendi);
//        }
//    }

@RequestMapping("/zhunk")
public List<Bendi>  tjjdf(@RequestBody Bendi bendi) {
    String key = "ZhunkList";
    ListOperations<String, Bendi> operations = redisTemplate.opsForList();
    if (redisTemplate.hasKey(key)) {
        return operations.range(key, 0, -1);
    } else {
        List<Bendi> bendis = zhun_ke_hu_zi_liaoMapper.selectListk(bendi);
        operations.leftPushAll(key, bendis);
        return bendis;
    }
}
    @RequestMapping("/zhunid2")
    public List<Bendi> thdfgfgkh(@RequestBody String  djgh) {
        int id = 0;
        String[] array = new String[1];
        array = djgh.split("=");
        for (String a : array) {
            id = Integer.parseInt(a);
        }
        List<Bendi> bendis = zhun_ke_hu_zi_liaoMapper.selectById2(id);
        return bendis;

    }
    @RequestMapping("/zhunid")
    public Object thdkh(@RequestBody String  tadf){

        int id=0;
        String[] array= new String[1];
        array=tadf.split("=");
        for(String a :array){
            id=Integer.parseInt(a);
        }
        List<Object> zhun_ke_hu_zi_liao = zhun_ke_hu_zi_liaoMapper.selectById(id);
        return zhun_ke_hu_zi_liao;
    }
    @RequestMapping("/addzhun")
    public void jkfdjf(@RequestBody Zhun_ke_hu_zi_liao zhun_ke_hu_zi_liao){
        zhun_ke_hu_zi_liaoMapper.addZhun(zhun_ke_hu_zi_liao);
    }
    @RequestMapping("/deleteZhun")
    public int dkfjf(@RequestBody String  dfhdfh){
        int id=0;
        String[] array= new String[1];
        array=dfhdfh.split("=");
        for(String a :array){
            id=Integer.parseInt(a);
        }
        int count = zhun_ke_hu_zi_liaoMapper.deleteByPrimaryKey(id);
        String key = "ZhunkList" + id;
        if (redisTemplate.hasKey(key)) {
            //删除对应缓存
            redisTemplate.delete(key);
        }
        return count;
    }
    @RequestMapping("/toupdate")
    public Bendi dkdfdf(@RequestBody String  dfhdfh) {
        int id = 0;
        String[] array = new String[1];
        array = dfhdfh.split("=");
        for (String a : array) {
            id = Integer.parseInt(a);
        }
        String key = "ZhunList" + id;
        ValueOperations<String, Bendi> operations = redisTemplate.opsForValue();
        //缓存存在
        if (redisTemplate.hasKey(key)) {
            return operations.get(key);
        } else {
            Bendi bendi = zhun_ke_hu_zi_liaoMapper.selectById3(id);
            operations.set(key, bendi);
            return bendi;
        }
    }
    @RequestMapping("/updateZhun")
    public int djfkd(@RequestBody Bendi bendi){
        int count = zhun_ke_hu_zi_liaoMapper.updateZhun(bendi);
        ValueOperations operations = redisTemplate.opsForValue();
        //缓存存在
        String key = "ZhunList" + bendi.getId();
        if (redisTemplate.hasKey(key)) {
            //更新缓存
            Bendi bendi1 = zhun_ke_hu_zi_liaoMapper.selectById3(bendi.getId());
            operations.set(key, bendi1);
        }
        return count;
    }
    @RequestMapping("/pi1")
    public void deletepi(@RequestBody String [] spli) throws IOException {

        zhun_ke_hu_zi_liaoMapper.deletepi(spli);
    }
}
