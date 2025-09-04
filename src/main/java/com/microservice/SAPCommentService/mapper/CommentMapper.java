package com.microservice.SAPCommentService.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.microservice.SAPCommentService.dto.*;
import com.microservice.SAPCommentService.model.Comment;

/*
 * This is the mapper interface for the comments table in the database.
 * It has the folowing methods:
 * - toModel: convert CommentRequest to Comment
 * - toResponse: convert Comment to CommentResponse
 * - toResponseList: convert List<Comment> to List<CommentResponse>
 */

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "commentId", ignore = true)
    Comment toModel(CommentRequest request);

    CommentResponse toResponse(Comment comment);

    List<CommentResponse> toResponseList(List<Comment> comments);
}
