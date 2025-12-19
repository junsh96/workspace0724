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
@Table(name = "PRODUCT")
public class Product {

    @Id
    private Long id;
    @Column(unique = true)
    private int no;
    @Column(length = 200, nullable = false)
    private String title;
    @Column(length = 500 , nullable = false)
    private String content;
    @Lob
    private String image;
    private Integer count;
    private Integer price;
    @CreationTimestamp
    @Column(name="create_date")
    private LocalDateTime createdDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    @Column(name="user_id",nullable = false)
    private String userId;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();


    public enum Status {
        progress,complete
    }

    public void update(String title, String content, int price) {
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public void updateCount(Integer count) {
        this.count = count;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

}
