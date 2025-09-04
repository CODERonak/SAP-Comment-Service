package com.microservice.SAPCommentService.dto;

import lombok.Data;

@Data
public class CommentRequest {
    private Long commentId;

    private Long postId;

    private Long authorId;
    
    private String content;
}
