package com.lih.userserver.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.lih.userserver.entity.User;

public interface UserService {
    /**
     * 用户登录
     * @param jsonNode 参数
     * @return 返回值
     * @throws Exception 异常
     */
    JsonNode loginUser(JsonNode jsonNode) throws Exception;
    /**
     * 用户注册
     * @param jsonNode 参数
     * @return 返回值
     * @throws Exception 异常
     */
    JsonNode insertUser(JsonNode jsonNode) throws Exception;
}
