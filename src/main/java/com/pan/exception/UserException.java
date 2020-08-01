package com.pan.exception;

import com.pan.enums.BaseExceptionEunm;
import com.pan.enums.UserExceptionEunm;

public class UserException extends BaseException{
    /*
     *错误编码
     */
    private int err_code;

    /*
     * 错误描述
     * */
    private String err_msg;

    public UserException(String err_msg) {
        super(err_msg);
    }

    public UserException(String err_msg, int err_code) {
        super(err_msg);
        this.err_code = err_code;
        this.err_msg = err_msg;
    }
    public UserException(UserExceptionEunm userExceptionEunm) {
        super(userExceptionEunm.getErr_msg());
        this.err_code = userExceptionEunm.getErr_code();
        this.err_msg = userExceptionEunm.getErr_msg();
    }

    @Override
    public int getErr_code() {
        return err_code;
    }

    @Override
    public void setErr_code(int err_code) {
        this.err_code = err_code;
    }

    @Override
    public String getErr_msg() {
        return err_msg;
    }

    @Override
    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }
}
