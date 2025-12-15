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
        private Integer id;
        private String comment;
        private String userId;
        private Long productId;

        public static SimpleDto of(Comment comment) {

            return SimpleDto.builder()
                    .id(comment.getId())
                    .comment(comment.getComment())
                    .userId(comment.getUserId())
                    .productId(comment.getProductId())
                    .build();

        }
    }
}
