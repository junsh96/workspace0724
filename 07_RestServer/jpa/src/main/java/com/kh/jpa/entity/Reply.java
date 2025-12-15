package com.kh.jpa.entity;

import com.kh.jpa.enums.CommonEnums;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "REPLY")
public class Reply extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_no")
    private Long replyNo;

    @Column(name = "reply_content", length = 400, nullable = false)
    private String replyContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_bno", nullable = false)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_writer", nullable = false)
    private Member writer;

    @Enumerated(EnumType.STRING)
    @Column(length = 1, nullable = false)
    private CommonEnums.Status status;
}


