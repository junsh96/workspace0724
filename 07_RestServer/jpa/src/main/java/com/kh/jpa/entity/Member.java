package com.kh.jpa.entity;

import com.kh.jpa.enums.CommonEnums;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MEMBER")
public class Member extends BaseTimeEntity {

    @Id
    @Column(length = 30)
    private String userId;

    @Column(length = 100, nullable = false)
    private String userPwd;

    @Column(length = 15, nullable = false)
    private String userName;

    @Column(length = 255)
    private String email;

    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    @Column(length = 13)
    private String phone;

    @Column(length = 100)
    private String address;

    public enum Gender {
        M, F
    }


    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private Profile profile;

    @OneToMany(mappedBy = "writer")
    private List<Notice> notices = new ArrayList<>();

    @OneToMany(mappedBy = "writer")
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "board")
    private List<Reply> replies = new ArrayList<>();


}
