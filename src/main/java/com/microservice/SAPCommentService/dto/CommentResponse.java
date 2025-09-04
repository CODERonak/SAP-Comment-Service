package com.microservice.SAPCommentService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentResponse {

    @NotNull
    private Long postId;

    @NotNull
    private Long authorId;

    @NotBlank
    private String content;
}
