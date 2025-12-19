package com.kh.resale.controller.dto.response;

import com.kh.resale.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class CommentResponse {
    @Getter
    @Setter
    @Builder
    public static class SimpleDto {
        private Long id;
        private String comment;
        private String user_id;
        private Long product_id;

        public static SimpleDto of(Comment comment) {

            return SimpleDto.builder()
                    .id(comment.getId())
                    .comment(comment.getComment())
                    .user_id(comment.getUserId())
                    .product_id(comment.getProductId())
                    .build();

        }
    }

    @Getter
    @Setter
    @Builder
    public static class ListDto {
        private Long id;
        private String comment;
        private String user_id;
        private Long product_id;

        public static ListDto of(Comment comment) {
            return ListDto.builder()
                    .id(comment.getId())
                    .comment(comment.getComment())
                    .user_id(comment.getUserId())
                    .product_id(comment.getProductId())
                    .build();
        }
    }
}
