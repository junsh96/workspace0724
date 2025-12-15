package com.kh.resale.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "COMMENT")
public class Comment {
    @Id
    private int id;
    @Column(length = 200)
    private String comment;
    @Column(name="user_id",nullable = false)
    private String userId;
    @Column(name="product_id")
    private long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
