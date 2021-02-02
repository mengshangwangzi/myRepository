package com.wangxu.result;

/**
 * @author wx
 * @Description:
 * @Title:
 * @Package
 * @date 2021/1/10 10:28
 */


public class Result {
    private String code;

    private String message;

    private String resultInfo;

    private Object data;

    public Result() {
    }

    public Result(String code, String message, String resultInfo) {
        this.code = code;
        this.message = message;
        this.resultInfo = resultInfo;
    }

    public Result(String code, String message, String resultInfo, Object data) {
        this.code = code;
        this.message = message;
        this.resultInfo = resultInfo;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
