package com.kh.jpa.entity;


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
@Table(name = "NOTICE")
public class Notice extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_no")
    private Long noticeNo;

    @Column(name = "notice_title", length = 30, nullable = false)
    private String noticeTitle;

    @Column(name = "notice_content", length = 200, nullable = false)
    private String noticeContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_writer", nullable = false)
    private Member writer;


}
