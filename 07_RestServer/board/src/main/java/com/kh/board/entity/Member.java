package com.kh.board.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Entity
@Table(name="MEMBER")
public class Member {
    @Id
    @Column(length=255)
    private String email;
    @Column(length=255, nullable=false)
    private String password;
    @Column(length=255, nullable=false)
    private String nickName;

    @CreationTimestamp
    @Column(name="create_at" , updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name="update_at")
    private LocalDateTime updateAt;

    /**
     *  MEMBER : BOARD 1:N의 관계
     *  mappedBy : "member" => board 엔티티의 member 주인
     *  cascade : 회원 삭제시 관련 게시글 모두 삭제
     */
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Board> boards = new ArrayList<>();
}
