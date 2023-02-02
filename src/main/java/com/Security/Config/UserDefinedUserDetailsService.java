package com.Security.Config;

import com.Security.Controller.SecurityController;
import com.Security.Models.UserModel;
import com.Security.Repository.UserRepo;
import com.Security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class UserDefinedUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repositorty;

    @Autowired
    private UserService Service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userInfo= repositorty.findByUserName(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
