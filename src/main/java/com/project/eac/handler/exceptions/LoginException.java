package com.project.eac.handler.exceptions;

import com.project.eac.handler.GlobalException;

import static com.project.eac.enums.HttpMessage.LOGIN_ERROR;

public class LoginException extends GlobalException {
    public LoginException(String message) {
        super(LOGIN_ERROR.getCode(), message);
    }
}
