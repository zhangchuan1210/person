package com.teligen.ito.person.common.model.vo;

import java.io.Serializable;

public class ResultVo<T> implements Serializable {
    private boolean status;
    private String code;
    private String msg;
    private T result;

    public ResultVo<T> success(T t){
       this.status=true;
       this.code="200";
       this.result=t;
       this.msg="操作成功";
       return this;
    }

    public ResultVo<T> fail(T t){
       this.status=false;
       this.code="400";
       this.result=t;
       this.msg="操作失败";
        return this;
    }



    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }





}
