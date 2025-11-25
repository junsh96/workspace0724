package com.kh.spring.model.vo;

import lombok.*;

import java.sql.Date;

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

}
