package com.kh.resale.mapper;

import com.kh.resale.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int  addUser(User user);

    User login(String userId, String userPwd);
}
