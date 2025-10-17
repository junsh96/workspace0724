package com.kh.mybatis.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
