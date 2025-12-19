package com.kh.resale.service;

import com.kh.resale.controller.dto.request.FavoriteRequest;
import com.kh.resale.controller.dto.request.ProductRequest;
import com.kh.resale.controller.dto.response.ProductResponse;
import com.kh.resale.entity.Favorite;
import com.kh.resale.entity.Product;
import com.kh.resale.entity.User;
import com.kh.resale.id.FavoriteId;
import com.kh.resale.mapper.ProductMapper;
import com.kh.resale.repository.ProductRepository;
import com.kh.resale.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    /**
     * 상품 등록
     * @param request
     * @return
     */
    @Override
    public int addProduct(ProductRequest.createDto request) {

        Long count = productRepository.count();
        Product product = request.toEntity(count +1);
        productRepository.save(product);
        return 1;
    }

    /**
     * 상품 리스트
     * @return
     */
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * 상세 조회
     * @param id
     * @return
     */
    @Override
    public ProductResponse.DetailDto findOne(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품 정보를 찾을수 없습니다."));

        return ProductResponse.DetailDto.of(product);
    }

    @Override
    public int delete(Long id) {
        Product selProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품 정보를 찾을수 없습니다."));

        productRepository.delete(selProduct);
        return 1;
    }

    @Override
    public int update(ProductRequest.UpdateDto request) {
        Product product = request.toEntity();
        Product selProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new IllegalArgumentException("상품 정보를 찾을수 없습니다."));

        selProduct.update(
                product.getTitle(),
                product.getContent(),
                product.getPrice()
        );
        return 1;
    }

    @Override
    public int patchStatus(String userId,Long id) {
        Product selProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품 정보를 찾을수 없습니다."));
        User loginUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을수 없습니다."));
        selProduct.updateStatus(Product.Status.complete);

        loginUser.updateAmount(loginUser.getAmount() + selProduct.getPrice());

        return 1;
    }

    @Override
    public int patchCount(Long id) {
        Product selProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품 정보를 찾을수 없습니다."));

        selProduct.updateCount(selProduct.getCount() + 1);
        return 1;
    }

    @Override
    public int addFavorite(FavoriteRequest.createDto request) {
        User user = userRepository.getReferenceById(request.getUser_id());
        Product product = productRepository.getReferenceById(request.getProduct_id());
        Favorite favorite = Favorite.builder()
                .id(new FavoriteId(request.getUser_id(), request.getProduct_id()))
                .user(user)
                .product(product)
                .build();

        return 1;
    }


}
