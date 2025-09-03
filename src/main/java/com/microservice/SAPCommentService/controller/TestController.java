package com.microservice.SAPCommentService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "SAP COMMENT SERVICE SERVER RUNNING!!!";
    }
}