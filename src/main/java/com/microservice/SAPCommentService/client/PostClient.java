package com.microservice.SAPCommentService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.SAPCommentService.dto.PostResponse;

@FeignClient(name = "SAP-Post-Service", url = "${POST_SERVICE}")
public interface PostClient {
    @GetMapping("api/posts/{postId}")
    PostResponse getPostById(@PathVariable("postId") Long postId);
}
