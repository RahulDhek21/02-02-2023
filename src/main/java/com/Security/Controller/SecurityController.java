package com.Security.Controller;

import com.Security.Models.UserModel;
import com.Security.Repository.UserRepo;
import com.Security.Service.UserService;
import org.apache.catalina.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping("/Secure")
public class SecurityController {

    @Autowired
    UserService service;
    @GetMapping("/demo")
    public String demo(){
        return "Welcome to Application.";
    }

    @GetMapping("/private")
    public String protect(){
        return "I am Private";
    }

    @PostMapping("/create")
    public ResponseEntity<?> created(@RequestBody UserModel obj){

        UserModel output = service.createUser(obj);
        System.out.println(output);
        if(output!=null){
            return ResponseEntity.status(HttpStatus.OK).body(output);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please give unique userName");
    }

    @GetMapping("/get/{UserName}")
    public ResponseEntity<?> getUser(@PathVariable String UserName){
        Optional<UserModel> output = service.getUser(UserName);
        if(output!=null){
            return ResponseEntity.status(HttpStatus.OK).body(output);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserName That you want is not in the DB");
    }

    @GetMapping("/get/Users")
    public ResponseEntity<List<UserModel>> getUser(){
        List<UserModel> output=service.getUser();
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

}
