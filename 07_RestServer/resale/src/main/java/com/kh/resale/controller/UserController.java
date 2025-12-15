package com.kh.resale.controller;

import com.kh.resale.controller.dto.request.LoginUserRequest;
import com.kh.resale.controller.dto.request.UserRequest;
import com.kh.resale.entity.User;
import com.kh.resale.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserServiceImpl userService;


    @PostMapping
    public ResponseEntity<String> addUser(UserRequest.createDto request){

        if (request == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = request.toEntity();
        int result = userService.addUser(user);

        if(result > 0){
            return new ResponseEntity<>("유저 등록 성공", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("유저 등록 실패", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    public ResponseEntity<User> login(LoginUserRequest request){

        if (request == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = userService.login(request.getUserId(), request.getUserPwd());

        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }








}
