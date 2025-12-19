package com.kh.resale.controller;

import com.kh.resale.controller.dto.request.CommentRequest;
import com.kh.resale.controller.dto.response.CommentResponse;
import com.kh.resale.entity.Comment;
import com.kh.resale.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/comment")
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 등록
     * @param request
     * @return
     */
    @PostMapping("/addComment")
    public ResponseEntity<String> addComment(@RequestBody CommentRequest.createDto request) {

        int result = commentService.addComment(request);
        if(result > 0){
            return new ResponseEntity<>("댓글 등록 성공", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("댓글 등록 실패", HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * 댓글 삭제
     * @param commentId
     * @return
     */
    @DeleteMapping("/deleteComment")
    public ResponseEntity<String> deleteComment(@RequestParam Long commentId) {

        int result = commentService.delete(commentId);

        return new ResponseEntity<>( "댓글 삭제완료", HttpStatus.OK);
    }

    @GetMapping("/getComment")
    public ResponseEntity<List<CommentResponse.ListDto>> getComment(@RequestParam Long productId) {

        List<Comment> comments = commentService.getComments(productId);

        List<CommentResponse.ListDto> result = new ArrayList<>();

        for (Comment comment : comments) {
            result.add(CommentResponse.ListDto.of(comment));
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
