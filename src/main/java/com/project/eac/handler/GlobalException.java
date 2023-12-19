package com.project.eac.handler;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GlobalException extends RuntimeException{

    protected Integer code;

    protected String message;

    public GlobalException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
