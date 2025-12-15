package com.kh.resale.controller.dto.request;

import com.kh.resale.entity.Comment;


public class CommentRequest {

    public static class createDto {

        private Integer id;
        private String comment;
        private String userId;
        private Long productId;

        public Comment toEntity() {
            return Comment.builder().
                    id(id)
                    .comment(comment)
                    .userId(userId)
                    .productId(productId)
                    .build();
        }

    }

}
