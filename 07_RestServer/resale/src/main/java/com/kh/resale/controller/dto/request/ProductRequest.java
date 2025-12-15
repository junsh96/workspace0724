package com.kh.resale.controller.dto.request;

import com.kh.resale.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ProductRequest {

    public static class createDto {
        private Long id;
        private Integer no;
        private String userId;
        private String title;
        private String content;
        private String image;
        private Integer price;
        private LocalDateTime createdDate;
        private String status;


        public Product toEntity() {
            return Product.builder()
                    .id(id)
                    .no(no)
                    .userId(userId)
                    .content(content)
                    .image(image)
                    .price(price)
                    .createdDate(createdDate)
                    .status(status)
                    .build();
        }
    }

    public static class UpdateDto {
        private Long id;
        private Integer no;
        private String userId;
        private String title;
        private String content;
        private String image;
        private Integer price;

        public Product toEntity() {
            return Product.builder()
                    .id(id)
                    .no(no)
                    .userId(userId)
                    .title(title)
                    .content(content)
                    .image(image)
                    .price(price)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class PatchStatusDto {
        private Long id;
        private Integer no;
        private String userId;
        private String status;
    }

    @Getter
    @Setter
    public static class PatchCountDto {
        private Long id;
        private Integer no;
        private String userId;
        private int count;
    }

}
