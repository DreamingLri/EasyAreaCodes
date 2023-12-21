package com.project.eac.handler;

import com.project.eac.domain.Result;
import com.project.eac.enums.HttpMessage;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import static com.project.eac.constants.HttpStatus.*;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e){
        if(e instanceof GlobalException exception){
            return Result.error(exception.getCode(), exception.getMessage());
        }
        if (e instanceof ConstraintViolationException exception)
            return Result.error(HTTP_STATUS_422, exception.getMessage());
        if (e instanceof MethodArgumentNotValidException exception)
            if (exception.getFieldError() != null)
                return Result.error(HTTP_STATUS_422, exception.getFieldError().getDefaultMessage());
        if (e instanceof BindException exception)
            return Result.error(HTTP_STATUS_422, exception.getMessage());
        e.printStackTrace();
        return Result.error(HttpMessage.SYSTEM_ERROR);
    }
}
