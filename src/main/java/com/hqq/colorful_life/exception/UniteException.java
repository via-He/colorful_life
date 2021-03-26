package com.hqq.colorful_life.exception;

import lombok.Data;

/**
 * @author Qingqing.He
 * @date 2021/3/16 11:24
 */
@Data
public class UniteException extends RuntimeException{
    private final Integer code;
    private final String message;

    public UniteException(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public UniteException(ExceptionEnum exceptionEnum){
        this(exceptionEnum.getCode(),exceptionEnum.getMsg());
    }
}

