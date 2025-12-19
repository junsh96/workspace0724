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
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequest.createDto request) {
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        int result = productService.addProduct(request);
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
    @GetMapping("/findAll")
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
     * @param productId
     * @return
     */
    @GetMapping("/getProduct")
    public ResponseEntity<ProductResponse.DetailDto> getProduct(@RequestParam Long productId) {
        System.out.println(productId);
        ProductResponse.DetailDto result = productService.findOne(productId);


        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 삭제
     * @param productId
     * @return
     */
    @DeleteMapping("/deleteProduct")
    public ResponseEntity<String> deleteProduct(@RequestParam Long productId) {
        int result = productService.delete(productId);


        return new ResponseEntity<>(result + "개의 게시글 삭제완료", HttpStatus.OK);
    }

    /**
     * 수정
     * @param request
     * @return
     */
    @PutMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody ProductRequest.UpdateDto request) {


        int result = productService.update(request);

        return new ResponseEntity<>("게시글 수정완료", HttpStatus.OK);

    }

    /**
     * 판매 완료 처리
     * @param userId
     * @param productId
     * @return
     */
    @PatchMapping("/updateStatus")
    public ResponseEntity<String> updateProduct(@RequestParam String userId, @RequestParam Long productId) {

        int result = productService.patchStatus(userId,productId);

        return new ResponseEntity<>("게시글 수정완료", HttpStatus.OK);
    }

    /**
     * 조회수 증가
     * @param productId
     * @return
     */
    @PatchMapping("/updateCount")
    public ResponseEntity<String> updateProduct(@RequestParam Long productId) {
        int result = productService.patchCount(productId);

        return new ResponseEntity<>("게시글 수정완료", HttpStatus.OK);
    }

}
