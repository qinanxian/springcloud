package com.lih.userserver.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.lih.userserver.entity.User;
import com.lih.userserver.mapper.UserMapper;
import com.lih.userserver.service.UserService;
import com.lih.userserver.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public String insertUser(User user) {
        String uuid = CommonUtil.getUUID();
        user.setId(uuid);
        int insert = userMapper.insert(user);
        return "2";
    }
}
