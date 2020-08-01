package com.pan.utils;

import com.pan.enums.BaseExceptionEunm;
import com.pan.exception.BaseException;

import java.io.Serializable;

public class ResponseResult implements Serializable {

    private static final long serialVersionUID = -3377651730297917992L;
    private Integer error_code;
    private String error_message;
    private Object reference;

    public ResponseResult() {

    }

    public ResponseResult(Object reference) {
        this.error_code = BaseExceptionEunm.SUCCESS_CODE.getErr_code();
        this.error_message = BaseExceptionEunm.SUCCESS_CODE.getErr_msg();
        this.reference = reference;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public Object getReference() {
        return reference;
    }

    public void setReference(Object reference) {
        this.reference = reference;
    }
}
