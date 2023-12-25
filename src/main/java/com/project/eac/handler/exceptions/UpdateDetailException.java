package com.project.eac.handler.exceptions;

import com.project.eac.handler.GlobalException;

import static com.project.eac.enums.HttpMessage.UPDATE_DETAIL_ERROR;

public class UpdateDetailException extends GlobalException {
    public UpdateDetailException(String message) {
        super(UPDATE_DETAIL_ERROR.getCode(), message);
    }
}
