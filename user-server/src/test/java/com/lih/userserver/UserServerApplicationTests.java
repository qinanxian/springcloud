package com.lih.userserver;

import com.lih.userserver.controller.UserController;
import com.lih.userserver.entity.User;
import com.lih.userserver.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

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
    public void test(){
        redisTemplate.opsForValue().set("1","例会");
        String s = redisTemplate.opsForValue().get("1");
        System.out.println(s);
    }

}
