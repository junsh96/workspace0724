package com.kh.resale.service;

import com.kh.resale.entity.User;

public interface UserService {
    int  addUser(User user);

    User login(String userId, String userPwd);
}
