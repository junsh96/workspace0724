package com.kh.resale.service;

import com.kh.resale.controller.dto.request.UserRequest;
import com.kh.resale.controller.dto.response.UserResponse;
import com.kh.resale.entity.User;

public interface UserService {
    int  addUser(UserRequest.createDto request);

    UserResponse.SimpleDto login(String userId, String userPwd);

    int getUserByUserId(String userId);
}
