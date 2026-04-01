package com.example.springbootapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/status")
    public String getStatus() {
        return "Spring Boot backend is running and ready to connect to Oracle Database!";
    }
}
