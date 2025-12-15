package com.kh.resale.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginUserRequest {

    private String userId;
    private String userPwd;
}
