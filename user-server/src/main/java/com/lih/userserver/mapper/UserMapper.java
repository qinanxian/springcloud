package com.lih.userserver.mapper;

import com.lih.userserver.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper{
    List<User> getUser();
}
