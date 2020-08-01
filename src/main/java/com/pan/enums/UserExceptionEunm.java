package com.pan.enums;

public enum UserExceptionEunm {

    USER_INVALID(2001,"用户不存在！");

    private Integer err_code;
    private String err_msg;

    UserExceptionEunm(Integer err_code, String err_msg) {
        this.err_code = err_code;
        this.err_msg = err_msg;
    }

    public Integer getErr_code() {
        return err_code;
    }

    public void setErr_code(Integer err_code) {
        this.err_code = err_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }
}
