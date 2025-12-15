package com.kh.resale.service;

import com.kh.resale.entity.User;
import com.kh.resale.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public int addUser(User user) {

        return userMapper.addUser(user);
    }

    @Override
    public User login(String userId, String userPwd) {

        return userMapper.login(userId,userPwd);
    }


}
