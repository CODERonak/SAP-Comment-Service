package com.microservice.SAPCommentService.dto;

import lombok.Data;

@Data
public class PostResponse {
    private Long postId;

    private Long userId;

    private String title;

    private String content;
}