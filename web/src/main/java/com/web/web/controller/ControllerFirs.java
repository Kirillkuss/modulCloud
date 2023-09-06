package com.web.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerFirs {
    
    @GetMapping("/test")
    public String getHelloWorld() {
       return "Hello World ";
    }
}
