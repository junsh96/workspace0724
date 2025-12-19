package com.kh.resale.service;

import com.kh.resale.controller.dto.request.FavoriteRequest;
import com.kh.resale.controller.dto.response.ProductResponse;
import com.kh.resale.controller.dto.response.UserResponse;
import com.kh.resale.entity.Comment;
import com.kh.resale.entity.Product;
import com.kh.resale.entity.User;

import java.util.List;

public interface MyPageService {
    UserResponse.SimpleDto getUserById(String userId);

    List<Product> getProductByUserId(String userId);

    List<Comment> getCommentByUserId(String userId);

}
