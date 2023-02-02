package com.Security.Service;

import com.Security.Models.UserModel;
import com.Security.Repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repository;

    @Autowired
    private PasswordEncoder PassEncoder;

    public UserModel createUser(UserModel obj){
        obj.setPassword(PassEncoder.encode(obj.getPassword()));
        try{return repository.save(obj);

        }
        catch (Exception ex){
            return null;
        }
    }
    public Optional<UserModel> getUser(String UserName){
//        return repository.findByUserName(UserName).get(0);
        Optional<UserModel> usersOptional = repository.findByUserName(UserName);
        return usersOptional;
    }

    public List<UserModel> getUser(){
        return repository.findAll();
    }
}
