package com.atguigu.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {

    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private R(){}

    public static R succ(){
        R r = new R();
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMsg());
        return r;
    }

    public static R fail(){
        R r = new R();
        r.setCode(ResponseEnum.FAIL.getCode());
        r.setMessage(ResponseEnum.FAIL.getMsg());
        return r;
    }

    public R data(String key, Object val){
        this.data.put(key, val);
        return this;
    }

    public R msg(String msg){
        this.message = msg;
        return this;
    }

    public R data(Map<String, Object> map){
        this.data = map;
        return this;
    }

    public R code(Integer code){
        this.code = code;
        return this;
    }

    public static R set(ResponseEnum e){
        R r = new R();
        r.code = e.getCode();
        r.message = e.getMsg();
        return r;
    }

    public static R error(){
        return R.set(ResponseEnum.FAIL);
    }

}
