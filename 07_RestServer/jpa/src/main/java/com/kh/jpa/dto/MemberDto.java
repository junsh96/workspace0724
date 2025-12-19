package com.kh.jpa.dto;

import com.kh.jpa.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class MemberDto {
    public static class Create {
        private String user_id;
        private String user_pwd;
        private String user_name;
        private String email;
        private Member.Gender gender;
        private Integer age;
        private String phone;
        private String address;

        public Member toEntity() {
            return null;
        }
    }
}
