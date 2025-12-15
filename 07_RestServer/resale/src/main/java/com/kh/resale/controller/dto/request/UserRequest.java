package com.kh.resale.controller.dto.request;

import com.kh.resale.entity.User;

import java.time.LocalDateTime;

public class UserRequest {

    public static class createDto {
        private String userId;
        private String password;
        private String userName;
        private LocalDateTime joinDate;
        private int amount;

        public User toEntity() {
            return User.builder()
                    .userId(userId)
                    .password(password)
                    .userName(userName)
                    .joinDate(joinDate)
                    .amount(amount)
                    .build();
        }
    }
}
