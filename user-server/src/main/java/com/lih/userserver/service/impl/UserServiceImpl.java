package com.lih.userserver.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.lih.userserver.entity.User;
import com.lih.userserver.mapper.UserMapper;
import com.lih.userserver.service.UserService;
import com.lih.userserver.util.CommonUtil;
import com.lih.userserver.util.JsonUtil;
import com.lih.userserver.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.spring.web.json.Json;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public JsonNode insertUser(JsonNode jsonNode) throws Exception {
        ReturnResult returnResult = new ReturnResult();
        User userJSON = JsonUtil.getJavaFromJson(jsonNode, User.class);

        User user = userMapper.getCardidAndPhone(userJSON.getCardid(), userJSON.getPhone());
        if(user==null){
            String uuid = CommonUtil.getUUID();
            userJSON.setId(uuid);
            int insert = userMapper.insert(userJSON);
            if(insert>0){
                returnResult.setMessage("注册成功");
            }
        }else{
            returnResult.setCode("0");
            returnResult.setMessage("当前手机号/身份证号已被注册");
            returnResult.setSuccess("fail");
        }

        return JsonUtil.getJsonByJava(returnResult);
    }
}
