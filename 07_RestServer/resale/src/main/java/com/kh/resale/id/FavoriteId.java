package com.kh.resale.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class FavoriteId implements java.io.Serializable {

    @Column(name="user_id" , nullable = false)
    private String userId;

    @Column(name="product_id", nullable = false)
    private Long productId;

}
