package com.kh.resale.service;

import com.kh.resale.controller.dto.request.UserRequest;
import com.kh.resale.controller.dto.response.UserResponse;
import com.kh.resale.entity.User;
import com.kh.resale.mapper.UserMapper;
import com.kh.resale.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public int addUser(UserRequest.createDto request) {
        User user = request.toEntity();
        userRepository.save(user);
        return 1;
    }

    @Override
    public int getUserByUserId(String userId) {
        return userRepository.existsById(userId) ? 1 : 0;
    }

    @Override
    public UserResponse.SimpleDto login(String userId, String userPwd) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));

        if(!user.getPassword().equals(userPwd)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        return UserResponse.SimpleDto.of(user);
    }



}
