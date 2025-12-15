package com.kh.resale.controller.dto.response;

import com.kh.resale.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ProductResponse {
    @Getter
    @Setter
    @Builder
    public static class SimpleDto {

        private Long id;
        private Integer no;
        private String userId;
        private String title;
        private String content;
        private String image;
        private Integer count;
        private Integer price;
        private LocalDateTime createDate;
        private String status;

        public static SimpleDto of(Product product) {


            return SimpleDto.builder()
                    .id(product.getId())
                    .no(product.getNo())
                    .userId(product.getUserId())
                    .title(product.getTitle())
                    .content(product.getContent())
                    .image(product.getImage())
                    .count(product.getCount())
                    .price(product.getPrice())
                    .createDate(product.getCreatedDate())
                    .status(product.getStatus())
                    .build();

        }

    }

    @Getter
    @Setter
    @Builder
    public static class DetailDto {
        private Long id;
        private Integer no;
        private String userId;
        private String title;
        private String content;
        private String image;
        private Integer count;
        private Integer price;
        private LocalDateTime createDate;
        private String status;

        public static DetailDto of(Product product) {
            return DetailDto.builder()
                    .id(product.getId())
                    .no(product.getNo())
                    .userId(product.getUserId())
                    .title(product.getTitle())
                    .content(product.getContent())
                    .image(product.getImage())
                    .count(product.getCount())
                    .price(product.getPrice())
                    .createDate(product.getCreatedDate())
                    .status(product.getStatus())
                    .build();
        }
    }

}
