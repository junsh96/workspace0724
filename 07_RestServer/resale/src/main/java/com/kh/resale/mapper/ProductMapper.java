package com.kh.resale.mapper;

import com.kh.resale.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    int  addProduct(Product product);

    List<Product> findAll();

    Product findOne(Long id);

    int delete(Long id);

    int update(Product product);

    int patchStatus(Long id);

    int patchCount(Long id);
}
