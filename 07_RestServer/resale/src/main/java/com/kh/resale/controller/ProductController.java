package com.kh.resale.controller;

import com.kh.resale.controller.dto.request.ProductRequest;
import com.kh.resale.controller.dto.response.ProductResponse;
import com.kh.resale.entity.Product;
import com.kh.resale.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    /**
     * 게시글 등록
     * @param request
     * @return
     */
    @PostMapping
    public ResponseEntity<String> addProduct(ProductRequest.createDto request) {
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Product product = request.toEntity();
        int result = productService.addProduct(product);
        if(result > 0){
            return new ResponseEntity<>("게시글 등록 성공", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("게시글 등록 실패", HttpStatus.BAD_REQUEST);
        }
    }


    /**
     *  게시글 조회
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ProductResponse.SimpleDto>> findAll() {

        List<Product> products = productService.findAll();
        List <ProductResponse.SimpleDto> result = new ArrayList<>();
        for (Product product : products) {
            result.add(ProductResponse.SimpleDto.of(product));
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 상세 조회
     * @param id
     * @return
     */
    @GetMapping
    public ResponseEntity<ProductResponse.DetailDto> getProduct(@PathVariable Long id) {
        Product product = productService.findOne(id);
        ProductResponse.DetailDto result = ProductResponse.DetailDto.of(product);


        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 삭제
     * @param id
     * @return
     */
    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        int result = productService.delete(id);


        return new ResponseEntity<>(result + "개의 게시글 삭제완료", HttpStatus.OK);
    }

    /**
     * 수정
     * @param request
     * @return
     */
    @PutMapping
    public ResponseEntity<String> updateProduct(ProductRequest.UpdateDto request) {

        Product product = request.toEntity();
        int result = productService.update(product);

        return new ResponseEntity<>("게시글 수정완료", HttpStatus.OK);

    }

    /**
     * 판매 완료 처리
     * @param request
     * @return
     */
    @PatchMapping
    public ResponseEntity<String> updateProduct(ProductRequest.PatchStatusDto request) {
        int result = productService.patchStatus(request.getId());

        return new ResponseEntity<>("게시글 수정완료", HttpStatus.OK);
    }

    /**
     * 조회수 증가
     * @param request
     * @return
     */
    @PatchMapping
    public ResponseEntity<String> updateProduct(ProductRequest.PatchCountDto request) {
        int result = productService.patchCount(request.getId());

        return new ResponseEntity<>("게시글 수정완료", HttpStatus.OK);
    }

}
