package com.kh.jpa.entity;

import com.kh.jpa.enums.CommonEnums;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "BOARD")
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

    @Column(name = "board_title", length = 100, nullable = false)
    private String boardTitle;

    @Lob
    @Column(name = "board_content", nullable = false)
    private String boardContent;

    @Column(name = "origin_name", length = 100)
    private String originName;

    @Column(name = "change_name", length = 100)
    private String changeName;

    @Column(nullable = false)
    private Integer count;

    @Enumerated(EnumType.STRING)
    @Column(length = 1, nullable = false)
    private CommonEnums.Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_writer", nullable = false)
    private Member writer;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardTag> boardTags = new ArrayList<>();

}
