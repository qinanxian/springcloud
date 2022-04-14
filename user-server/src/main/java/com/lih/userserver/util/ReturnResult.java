package com.lih.userserver.util;

public class ReturnResult {
    /**
     *1.成功 2.失败
     */
    private String code;
    /**
     * success.成功 fail.失败
     */
    private String success;
    /**
     *返回信息
     */
    private String message;

    public ReturnResult(){
        this.code="1";
        this.success="success";
        this.message="";
    }

    public ReturnResult(String code,String success,String message){
        this.code="1";
        this.success="success";
        this.message="";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ReturnResult{" +
                "code=" + code +
                ", success='" + success + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
