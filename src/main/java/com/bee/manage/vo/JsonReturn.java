package com.bee.manage.vo;



import net.sf.json.JSONObject;

import java.io.Serializable;

public class JsonReturn implements Serializable {
    private static final long serialVersionUID = 1L;

    private Boolean success = false;//请求成功与否标识

    private Integer errorCode;//错误码

    private String error;//错误描述

    private Object data;//返回数据


    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public Integer getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}
