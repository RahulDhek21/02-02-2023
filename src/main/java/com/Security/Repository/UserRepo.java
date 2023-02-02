package com.Security.Repository;

import com.Security.Models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository<UserModel,String> {

    @Query
    Optional<UserModel> findByUserName(String username);
}
