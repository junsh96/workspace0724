package com.kh.resale.controller;

import com.kh.resale.controller.dto.request.FavoriteRequest;
import com.kh.resale.controller.dto.response.CommentResponse;
import com.kh.resale.controller.dto.response.ProductResponse;
import com.kh.resale.controller.dto.response.UserResponse;
import com.kh.resale.entity.Comment;
import com.kh.resale.entity.Favorite;
import com.kh.resale.entity.Product;
import com.kh.resale.service.MyPageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/myPage")
public class MyPageController {

    private final MyPageServiceImpl myPageService;

    /**
     * 내정보
     * @param userId
     * @return
     */
    @GetMapping("/myInfo")
    public ResponseEntity<UserResponse.SimpleDto> myInfo(@RequestParam String userId) {
        if (userId == null || userId.equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserResponse.SimpleDto result = myPageService.getUserById(userId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 내 게시글
     * @param userId
     * @return
     */
    @GetMapping("/myProduct")
    public ResponseEntity<List<ProductResponse.SimpleDto>> myProduct(@RequestParam String userId) {
        if (userId == null || userId.equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Product> products = myPageService.getProductByUserId(userId);

        List<ProductResponse.SimpleDto> result = new ArrayList<>();
        for (Product product : products) {
            result.add(ProductResponse.SimpleDto.of(product));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 내 댓글
     * @param userId
     * @return
     */
    @GetMapping("/myComment")
    public ResponseEntity<List<CommentResponse.SimpleDto>> myComment(@RequestParam String userId) {
        if  (userId == null || userId.equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Comment> comments = myPageService.getCommentByUserId(userId);

        List<CommentResponse.SimpleDto> result = new ArrayList<>();
        for (Comment comment : comments) {
            result.add(CommentResponse.SimpleDto.of(comment));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }






}
