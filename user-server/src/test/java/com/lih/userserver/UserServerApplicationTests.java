package com.lih.userserver;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.lih.userserver.controller.UserController;
import com.lih.userserver.entity.User;
import com.lih.userserver.mapper.UserMapper;
import com.lih.userserver.util.JsonUtil;
import com.lih.userserver.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import springfox.documentation.spring.web.json.Json;

import javax.xml.ws.Action;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class UserServerApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserController userController;

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("1","lihui");
        map.put("2","lihui");
        map.put("3","lihui");
        double v = redisUtil.decrHash("12", "2", 1);
        System.out.println(v);
    }

}
