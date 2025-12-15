package com.kh.resale.service;


import com.kh.resale.entity.Product;

import java.util.List;

public interface ProductService {
    int addProduct(Product product);

    List<Product> findAll();

    Product findOne(Long id);

    int delete(Long id);

    int update(Product product);

    int patchStatus(Long id);

    int patchCount(Long id);

}
