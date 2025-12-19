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
        private String user_id;
        private String user_name;
        private String password;
        private LocalDateTime join_date;
        private int amount;

        public static SimpleDto of(User user) {

            return SimpleDto.builder()
                    .user_id(user.getUserId())
                    .user_name(user.getUserName())
                    .password(user.getPassword())
                    .join_date(user.getJoinDate())
                    .amount(user.getAmount())
                    .build();
        }
    }


}
