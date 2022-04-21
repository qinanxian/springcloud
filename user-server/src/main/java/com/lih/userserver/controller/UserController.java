package com.lih.userserver.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.lih.userserver.entity.User;
import com.lih.userserver.mapper.UserMapper;
import com.lih.userserver.service.UserService;
import com.lih.userserver.util.JsonUtil;
import com.lih.userserver.util.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
//@Api(tags = "用户相关接口")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

    /**
     * 登录接口
     * @param jsonNode
     * @return
     */
    @RequestMapping(value = "/loginUser")
    public JsonNode loginUser(@RequestBody JsonNode jsonNode) throws Exception {
        return userService.loginUser(jsonNode);
    }

    /**
     * 注册接口
     * @param jsonNode
     * @return
     */
    @RequestMapping(value = "/insterUser")
    public JsonNode userTest(@RequestBody JsonNode jsonNode) throws Exception {
        return userService.insertUser(jsonNode);

    }


}
