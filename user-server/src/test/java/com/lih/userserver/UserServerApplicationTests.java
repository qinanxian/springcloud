package com.lih.userserver;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.lih.userserver.controller.UserController;
import com.lih.userserver.entity.User;
import com.lih.userserver.mapper.UserMapper;
import com.lih.userserver.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import springfox.documentation.spring.web.json.Json;

import javax.xml.ws.Action;
import java.util.List;

@SpringBootTest
class UserServerApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserController userController;

    @Autowired
    RedisTemplate <String,String> redisTemplate;

    @Test
    public void test() throws Exception {
        String s="{\n" +
                "    \"name\": \"李晖\",\n" +
                "    \"cardid\": \"620522199604064614\",\n" +
                "    \"accountNumber\": \"admin\",\n" +
                "    \"accountPassword\": \"111111\",\n" +
                "    \"phone\": \"15858268414\"\n" +
                "}";
        JsonNode json = JsonUtil.getJson(s);
        JsonNode jsonNode = userController.userTest(json);
        System.out.println(jsonNode);
    }

}
