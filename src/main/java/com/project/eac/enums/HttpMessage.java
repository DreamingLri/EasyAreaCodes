package com.project.eac.enums;

import lombok.Getter;

import static com.project.eac.constants.HttpStatus.*;

@Getter
public enum HttpMessage {
    SUCCESS(HTTP_STATUS_200, "success"),
    SYSTEM_ERROR(HTTP_STATUS_500, "system error"),

    LOGIN_ERROR(HTTP_STATUS_422, "login error"),

    UPDATE_DETAIL_ERROR(HTTP_STATUS_422, "update detail error");


    final Integer code;
    final String message;

    HttpMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
