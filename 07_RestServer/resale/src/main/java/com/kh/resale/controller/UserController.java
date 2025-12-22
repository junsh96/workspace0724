package com.kh.resale.controller;

import com.kh.resale.controller.dto.request.LoginUserRequest;
import com.kh.resale.controller.dto.request.UserRequest;
import com.kh.resale.controller.dto.response.UserResponse;
import com.kh.resale.entity.User;
import com.kh.resale.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl userService;


    /**
     * 회원가입
     * @param request
     * @return
     */
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserRequest.createDto request){

        if (request.getUser_id() == null || request.getUser_id().equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int result = userService.addUser(request);

        if(result > 0){
            return new ResponseEntity<>("유저 등록 성공", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("유저 등록 실패", HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * 아이디 중복 체크
     * @param userId
     * @return
     */
    @GetMapping("/idCheck")
    public ResponseEntity<Integer> idCheck(@RequestParam String userId){
        if(userId == null || userId.equals("")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        int result = userService.getUserByUserId(userId);

        return  ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse.SimpleDto> login(@RequestBody LoginUserRequest request){

        if (request.getUser_id() == null || request.getUser_id().equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserResponse.SimpleDto user = userService.login(request.getUser_id(), request.getPassword());

        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(user);
    }








}
