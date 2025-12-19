package com.kh.resale.controller.dto.request;

import com.kh.resale.entity.Favorite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class FavoriteRequest {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class createDto {
        private String user_id;
        private Long product_id;

        public Favorite toEntity() {
            return Favorite
        }
    }
}
