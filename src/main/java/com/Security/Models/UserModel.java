package com.Security.Models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String id;
    private String userName;
    private String title;
    private String content;

}
