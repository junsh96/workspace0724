package com.kh.resale.entity;

import com.kh.resale.id.FavoriteId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorite")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Favorite {

    @EmbeddedId
    private FavoriteId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private Product product;

}
