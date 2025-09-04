package com.microservice.SAPCommentService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.SAPCommentService.client.*;
import com.microservice.SAPCommentService.dto.*;
import com.microservice.SAPCommentService.exceptions.custom.NotFoundException;
import com.microservice.SAPCommentService.mapper.CommentMapper;
import com.microservice.SAPCommentService.model.Comment;
import com.microservice.SAPCommentService.repository.CommentRepository;

import feign.FeignException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final UserClient userClient;
    private final PostClient postClient;

    public CommentResponse createComment(CommentRequest request) {
        UserResponse user = null;

        try {
            user = userClient.getUserById(request.getAuthorId());
        } catch (FeignException.NotFound e) {
            throw new NotFoundException("User with id " + request.getAuthorId() + " not found");
        }

        PostResponse post = null;

        try {
            post = postClient.getPostById(request.getPostId());
        } catch (FeignException.NotFound e) {
            throw new NotFoundException("Post with id " + request.getPostId() + " not found");
        }

        if (user == null || post == null)
            throw new NotFoundException("User or post not found");

        Comment comment = commentMapper.toModel(request);
        commentRepository.save(comment);

        return commentMapper.toResponse(comment);
    }

    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId))
            throw new NotFoundException("Comment with id " + commentId + " not found");

        commentRepository.deleteById(commentId);
    }

    public List<CommentResponse> getCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);

        try {
            postClient.getPostById(postId);
        } catch (FeignException.NotFound e) {
            throw new NotFoundException("Post with id " + postId + " not found");
        }

        if (comments.isEmpty())
            throw new NotFoundException("No comments found for post with id" + postId);

        return commentMapper.toResponseList(comments);
    }

}
