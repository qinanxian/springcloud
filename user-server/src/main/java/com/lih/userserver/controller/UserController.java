package com.lih.userserver.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.lih.userserver.entity.User;
import com.lih.userserver.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "用户相关接口")
public class UserController {
    @Autowired
    UserMapper userMapper;


    @RequestMapping(value = "/user",method = RequestMethod.POST)
    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    @ApiImplicitParam(name = "user", value = "新增用户数据")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "添加用户", notes = "添加用户",produces="application/json")
    public List<User> userTest(String name){
        List<User> user = userMapper.getUser();
        return user;
    }
}
