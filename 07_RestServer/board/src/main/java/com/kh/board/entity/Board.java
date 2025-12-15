package com.kh.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "BOARD") // DB의 BOARD테이블과 매핑
public class Board {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;

    @Column(nullable = false, length = 255) //not null
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT") //not null
    private String contents;

    @Column(name = "file_name")
    private String fileName;


    private String memberEmail;
    @CreationTimestamp
    @Column(name="create_at" , updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name="update_at")
    private LocalDateTime updateAt;

    //Board : Member = N : 1 관계(다수의 게시글은 하나의 회원에 속한다)
    //LAZY : 실제 member정보가 필요할때 까지 조회를 지연
    //Board테이블에 member_email이라는 컬럼을 만들어서 해당 컬럼 값으로 Member테이블의 pk를 참조해라.
    @JoinColumn(name="member_email", nullable = false, insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
