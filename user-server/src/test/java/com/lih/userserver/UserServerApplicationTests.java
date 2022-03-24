package com.lih.userserver;

import com.lih.userserver.controller.UserController;
import com.lih.userserver.entity.User;
import com.lih.userserver.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Action;
import java.util.List;

@SpringBootTest
class UserServerApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserController userController;

    @Test
    public void test(){
        List<User> user = userMapper.getUser();
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

}
