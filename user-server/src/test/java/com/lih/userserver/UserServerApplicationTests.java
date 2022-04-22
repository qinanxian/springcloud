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
import java.lang.reflect.Field;
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
        HashMap<Object, Object> map = new HashMap<>();
        map.put("id","1");
        User user = MapToObject(map,new User().getClass());
        System.out.println(user.toString());
    }

    public  Map<String, Object> objectToMap(Object object){
        HashMap<String, Object> map = new HashMap<>();
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try{
                field.setAccessible(true);
                System.out.println(field.getName());
                System.out.println(field.get(object));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return map;
    }

    public  <T> T MapToObject(Map<Object,Object> map,Class<T> objClass) throws Exception {

            JsonNode jsonFromJava = JsonUtil.getJsonFromJava(map);
        T   javaFromJson = JsonUtil.getJavaFromJson(jsonFromJava, objClass);

        return javaFromJson;
    }

}
