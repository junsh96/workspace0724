package com.kh.resale.service;

import com.kh.resale.controller.dto.request.CommentRequest;
import com.kh.resale.entity.Comment;

import java.util.List;

public interface CommentService {
    int addComment(CommentRequest.createDto request);

    int delete (Long commentId);

    List<Comment> getComments(Long productId);
}
