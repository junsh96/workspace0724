package com.kh.resale.controller.dto.request;

import com.kh.resale.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class CommentRequest {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class createDto {

        private Long id;
        private String comment;
        private String user_id;
        private Long product_id;

        public Comment toEntity() {
            return Comment.builder().
                    id(id)
                    .comment(comment)
                    .userId(user_id)
                    .productId(product_id)
                    .build();
        }

    }

}
