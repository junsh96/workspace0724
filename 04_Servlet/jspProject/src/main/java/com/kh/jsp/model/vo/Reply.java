package com.kh.jsp.model.vo;

import java.sql.Date;

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
public class Reply {
	private int replyNo;
	private String replyContent;
	private int refBno;
	private int replyWriter;
	private Date createDate;
	private String status;
	
	private String memberId;
	
	public static Reply insertReply(String replyContent,int refBno,int replyWriter) {
		Reply r = new Reply();	
		r.setReplyContent(replyContent);
		r.setRefBno(refBno);
		r.setReplyWriter(replyWriter);
				
		return r;
	}
	
}
