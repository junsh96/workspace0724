package com.kh.resale.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name="user_id")
    private String userId;
    @Column(name="user_name", nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @CreationTimestamp
    @Column(name="join_date")
    private LocalDateTime joinDate;
    private Integer amount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

}
