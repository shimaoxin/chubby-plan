package com.shimaoxin.chubbyplan.exception;

import lombok.Data;

/**
 * @author ：shimaoxin
 * @date ：Created in 2022/3/4 18:23
 * @description：业务异常
 */
@Data
public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }
}

