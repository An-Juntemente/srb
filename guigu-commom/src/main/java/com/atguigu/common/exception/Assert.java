package com.atguigu.common.exception;

import com.atguigu.common.result.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class Assert {

    /**
     * 断言：参数不为Null
     * @param o
     * @param r
     */
    public static void notNull(Object o, ResponseEnum r){
        if (o == null){
            throw new BusinessException(r);
        }
    }

    /**
     * 断言：参数参数为null
     * @param o
     * @param r
     */
    public static void isNull(Object o, ResponseEnum r){
        if (o != null){
            throw new BusinessException(r);
        }
    }

    /**
     * 断言：参数相等
     * @param o1
     * @param o2
     * @param r
     */
    public static void assertEquals(Object o1, Object o2, ResponseEnum r){
        if (!o1.equals(o2)){
            throw new BusinessException(r);
        }
    }

    /**
     * 断言：参数不为空
     * @param s
     * @param r
     */
    public static void isNotEmpty(String s, ResponseEnum r){
        if (StringUtils.isEmpty(s)){
            throw new BusinessException(r);
        }
    }
}
