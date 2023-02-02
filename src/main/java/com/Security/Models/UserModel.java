package com.Security.Models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.util.Collection;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="AccessUsers")
public class UserModel {
    @Id
    private String id;
    @Indexed(unique = true)
    private String userName;
    private String password;
    private String role;

}
