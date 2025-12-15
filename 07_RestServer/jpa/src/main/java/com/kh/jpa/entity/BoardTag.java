package com.kh.jpa.entity;


import com.kh.jpa.id.BoardTagId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board_tag")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardTag {

    @EmbeddedId
    private BoardTagId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("boardNo")
    @JoinColumn(name = "board_no")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
