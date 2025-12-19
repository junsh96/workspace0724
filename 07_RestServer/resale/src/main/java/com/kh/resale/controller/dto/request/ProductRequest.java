package com.kh.resale.controller.dto.request;

import com.kh.resale.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class ProductRequest {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class createDto {
        private Long id;
        private String user_id;
        private String title;
        private String content;
        private String image;
        private Integer price;
        private LocalDateTime created_date;
        private Product.Status status;
        private Integer count;


        public Product toEntity(Long no) {
            return Product.builder()
                    .id(id)
                    .no(no.intValue())
                    .userId(user_id)
                    .title(title)
                    .content(content)
                    .image(image)
                    .price(price)
                    .createdDate(created_date)
                    .status(status)
                    .count(count)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class UpdateDto {
        private Long id;
        private Integer no;
        private String user_id;
        private String title;
        private String content;
        private String image;
        private Integer price;

        public Product toEntity() {
            return Product.builder()
                    .id(id)
                    .no(no)
                    .userId(user_id)
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
