package com.kh.jpa.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class BoardTagId implements Serializable {

    @Column(name = "board_no")
    private Long boardNo;

    @Column(name = "tag_id")
    private Long tagId;
}
