package com.microservice.SAPCommentService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * This is the repository interface for the comments table in the database.
 * It has the folowing method:
 * - List findByPostId: find all comments by postId or posts
 */

import com.microservice.SAPCommentService.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
