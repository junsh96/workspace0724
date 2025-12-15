package com.kh.resale.service;

import com.kh.resale.entity.Product;
import com.kh.resale.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public Product findOne(Long id) {
        return productMapper.findOne(id);
    }

    @Override
    public int delete(Long id) {
        return productMapper.delete(id);
    }

    @Override
    public int update(Product product) {
        return productMapper.update(product);
    }

    @Override
    public int patchStatus(Long id) {
        return productMapper.patchStatus(id);
    }

    @Override
    public int patchCount(Long id) {
        return productMapper.patchCount(id);
    }


}
