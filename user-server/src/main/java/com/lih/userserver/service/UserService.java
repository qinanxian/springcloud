package com.lih.userserver.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.lih.userserver.entity.User;

public interface UserService {
    JsonNode insertUser(JsonNode jsonNode) throws Exception;
}
