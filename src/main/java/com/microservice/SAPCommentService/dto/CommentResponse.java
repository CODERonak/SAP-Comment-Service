package com.microservice.SAPCommentService.dto;

import lombok.Data;

@Data
public class CommentResponse {

    private Long commentId;

    private Long postId;

    private Long authorId;

    private String content;
}
