package com.kh.resale.controller.dto.request;

import com.kh.resale.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class UserRequest {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class createDto {
        private String user_id;
        private String password;
        private String user_name;
        private LocalDateTime join_date;
        private int amount;

        public User toEntity() {
            return User.builder()
                    .userId(user_id)
                    .password(password)
                    .userName(user_name)
                    .joinDate(join_date)
                    .amount(amount)
                    .build();
        }
    }
}
