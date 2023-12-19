package com.project.eac.domain;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.project.eac.enums.HttpMessage;


public record Result<T>(Integer code, String message, T data) {
    public static <T> Result<T> success(T data){
        return new Result<>(HttpMessage.SUCCESS.getCode(), HttpMessage.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> error(HttpMessage httpMessage){
        return new Result<>(httpMessage.getCode(), httpMessage.getMessage(), null);
    }

    public static <T> Result<T> error(Integer code, String message){
        return new Result<>(code, message, null);
    }

    public String toJsonString(){
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
}
