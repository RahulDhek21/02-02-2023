package com.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService USD(){
        UserDetails admin= User.withUsername("Vishal")
                .password("Vishal")
                .roles("Admin")
                .build();
        UserDetails user=User.withUsername("Roshan")
                .password("Roshan")
                .roles("User")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }

    @Bean
    public SecurityFilterChain SFC(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/Secure/demo")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return http.build();
    }

}
