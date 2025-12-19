package com.kh.resale.service;


import com.kh.resale.controller.dto.request.FavoriteRequest;
import com.kh.resale.controller.dto.request.ProductRequest;
import com.kh.resale.controller.dto.response.ProductResponse;
import com.kh.resale.entity.Product;

import java.util.List;

public interface ProductService {
    int addProduct(ProductRequest.createDto request);

    List<Product> findAll();

    ProductResponse.DetailDto findOne(Long id);

    int delete(Long id);

    int update(ProductRequest.UpdateDto request);

    int patchStatus(String userId,Long id);

    int patchCount(Long id);

    int addFavorite(FavoriteRequest.createDto request);

}
