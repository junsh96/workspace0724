package com.kh.resale.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    private long id;
    @Column(unique = true)
    private int no;
    @Column(name="user_id",nullable = false)
    private String userId;
    @Column(length = 200, nullable = false)
    private String title;
    @Column(length = 500 , nullable = false)
    private String content;
    @Column(length = 500)
    private String image;
    private Integer count;
    private Integer price;
    @CreationTimestamp
    @Column(name="create_date")
    private LocalDateTime createdDate;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

}
