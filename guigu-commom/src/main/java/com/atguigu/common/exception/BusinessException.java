package com.atguigu.common.exception;


import com.atguigu.common.result.ResponseEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@Data
public class BusinessException extends RuntimeException{

    private Integer code;

    private String msg;

    /**
     *
     * @param msg 错误消息
     */
    public BusinessException(String msg) {
        this.msg = msg;
    }

    /**
     *
     * @param msg 错误消息
     * @param code 错误码
     */
    public BusinessException(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    /**
     *
     * @param msg 错误消息
     * @param code 错误码
     * @param cause 原始异常对象
     */
    public BusinessException(String msg, Integer code, Throwable cause) {
        super(cause);
        this.msg = msg;
        this.code = code;
    }

    /**
     *
     * @param resultCodeEnum 接收枚举类型
     */
    public BusinessException(ResponseEnum resultCodeEnum) {
        this.msg = resultCodeEnum.getMsg();
        this.code = resultCodeEnum.getCode();
    }

    /**
     *
     * @param resultCodeEnum 接收枚举类型
     * @param cause 原始异常对象
     */
    public BusinessException(ResponseEnum resultCodeEnum, Throwable cause) {
        super(cause);
        this.msg = resultCodeEnum.getMsg();
        this.code = resultCodeEnum.getCode();
    }
}
