package com.lih.userserver.util;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReturnResult {
    private static Logger logger = LoggerFactory.getLogger(ReturnResult.class);

    public static String FAIL = "FAIL";
    public static String SUCCESS = "SUCCESS";
    private static String MSG_FAIL = "系统出错啦，请稍后再试哦";
    private static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     *success.成功 fail.失败
     */
    private String code;
    /**
     *
     */
    private String message;
    /**
     *返回信息
     */
    private Object body;
    private String repTime;

    public JsonNode toJson() {
        JsonNode nReturn = JsonUtil.getJson();
        try {
            JsonUtil.setJsonStringValue(nReturn, "header.code", this.code);
            JsonUtil.setJsonStringValue(nReturn, "header.message", this.message);
            this.repTime = DateUtil.getNowTime(DATE_FORMAT);
            JsonUtil.setJsonStringValue(nReturn, "footer.repTime", this.repTime);
            if (body != null) {
                if (body instanceof JsonNode) {
                    JsonUtil.setJsonValue(nReturn, "body", (JsonNode) body);
                } else if (body instanceof Double) {
                    JsonUtil.setJsonDoubleValue(nReturn, "body", (Double) body);
                } else if (body instanceof Integer) {
                    JsonUtil.setJsonIntValue(nReturn, "body", (Integer) body);
                } else {
                    JsonUtil.setJsonStringValue(nReturn, "body", body.toString());
                }
            }
        } catch (Exception e) {
            logger.error("数据返回异常！", e);
        }

        return nReturn;
    }




    public void fail() {
        this.code = FAIL;
        this.message = MSG_FAIL;
    }

    public void fail(String message) {
        this.code = FAIL;
        this.message = message;
    }

    public void success(String msg) {
        this.code = SUCCESS;
        this.message = msg;
    }

    public void success(String msg, Object body) {
        this.code = SUCCESS;
        this.message = msg;
        this.body = body;
    }


}
