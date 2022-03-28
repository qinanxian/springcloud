package com.lih.userserver.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.lih.userserver.entity.User;

public interface UserService {
    String insertUser(User user);
}
