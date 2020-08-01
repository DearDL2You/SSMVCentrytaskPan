package com.pan.handler;

import com.pan.enums.BaseExceptionEunm;
import com.pan.exception.BaseException;
import com.pan.utils.ExceptionResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class PanExceptionHandler {

    public PanExceptionHandler() {
    }

    @ExceptionHandler(Exception.class)
    public ExceptionResult handlePanException(Exception exception){

        ExceptionResult exceptionResult = new ExceptionResult();
        if(exception instanceof  BaseException){
            System.out.println("---BaseException");
            exceptionResult.setError_code(((BaseException) exception).getErr_code());
            exceptionResult.setError_message(((BaseException) exception).getErr_msg());
        }else {
            System.out.println("---@BaseException");
            exceptionResult.setError_code(BaseExceptionEunm.PAPAMETER_ERROR.getErr_code());
            exceptionResult.setError_message(BaseExceptionEunm.PAPAMETER_ERROR.getErr_msg());
        }
        return exceptionResult;
    }
}
