package com.kh.resale.controller.dto.response;

import com.kh.resale.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class UserResponse {

    @Getter
    @Setter
    @Builder
    public static class SimpleDto {
        private String userId;
        private String userName;
        private String password;
        private LocalDateTime joinDate;
        private int amount;
    }

    public static SimpleDto of(User user) {

        return SimpleDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .joinDate(user.getJoinDate())
                .amount(user.getAmount())
                .build();
    }
}
