package com.kh.resale.service;

import com.kh.resale.controller.dto.request.CommentRequest;
import com.kh.resale.entity.Comment;
import com.kh.resale.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public int addComment(CommentRequest.createDto request) {
        Comment comment = request.toEntity();
        commentRepository.save(comment);
        return 1;
    }

    @Override
    public int delete(Long commentId) {
        commentRepository.deleteById(commentId);
        return 1;
    }

    @Override
    public List<Comment> getComments(Long productId) {
        List<Comment> result = commentRepository.findByProductId(productId);

        return result;
    }
}
