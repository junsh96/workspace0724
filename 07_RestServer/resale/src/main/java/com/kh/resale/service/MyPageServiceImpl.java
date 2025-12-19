package com.kh.resale.service;

import com.kh.resale.controller.dto.request.FavoriteRequest;
import com.kh.resale.controller.dto.response.ProductResponse;
import com.kh.resale.controller.dto.response.UserResponse;
import com.kh.resale.entity.Comment;
import com.kh.resale.entity.Favorite;
import com.kh.resale.entity.Product;
import com.kh.resale.entity.User;
import com.kh.resale.id.FavoriteId;
import com.kh.resale.repository.CommentRepository;
import com.kh.resale.repository.ProductRepository;
import com.kh.resale.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MyPageServiceImpl implements MyPageService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;

    @Override
    public UserResponse.SimpleDto getUserById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저 정보를 찾을수 없습니다."));


        return UserResponse.SimpleDto.of(user);
    }

    @Override
    public List<Product> getProductByUserId(String userId) {
        List<Product> result = productRepository.findByUserId(userId);

        return result;
    }

    @Override
    public List<Comment> getCommentByUserId(String userId) {
        List<Comment> result = commentRepository.findByUserId(userId);
        return result;
    }


}
