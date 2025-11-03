package com.kh.spring.model.vo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int boardNo;
    private int boardType;
    private String boardTypeName;
    private int categoryNo;
    private String categoryName;
    private String boardTitle;
    private String boardContent;
    private int boardWriter;
    private String memberName;
    private int count;
    private String createDate;
    private String status;

    private String thumbnailImg;
    private String memberId;

}
