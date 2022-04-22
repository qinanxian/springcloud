package com.lih.userserver.util;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

  public static String SessionKey = "SESSION-TOKEN";
  public static String RedisPreKey = "SESSION:";

  public static String getCustomerId(HttpServletRequest request, RedisTemplate<String, Object> redisTemplate) throws Exception {
    String sessionId = request.getHeader(SessionKey);
    String session = (String) redisTemplate.opsForValue().get(RedisPreKey + sessionId);
    JsonNode nSession = JsonUtil.getJson(session);
    String sCustomerId = JsonUtil.getJsonStringValue(nSession, "customerid");

    return sCustomerId;
  }

  public static String getStringValue(HttpServletRequest request, RedisTemplate<String, Object> redisTemplate, String field) throws Exception {
    String sessionId = request.getHeader(SessionKey);
    String session = (String) redisTemplate.opsForValue().get(RedisPreKey + sessionId);
    JsonNode nSession = JsonUtil.getJson(session);
    String sCustomerId = JsonUtil.getJsonStringValue(nSession, field);

    return sCustomerId;
  }
}
