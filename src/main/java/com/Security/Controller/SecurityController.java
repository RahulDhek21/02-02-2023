package com.Security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Secure")
public class SecurityController {
    @GetMapping("/demo")
    public String demo(){
        return "Welcome to Application.";
    }

    @GetMapping("/private")
    public String protect(){
        return "I am Private";
    }

}
