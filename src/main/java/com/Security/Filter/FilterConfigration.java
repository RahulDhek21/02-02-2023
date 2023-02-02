package com.Security.Filter;

import jakarta.servlet.FilterRegistration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfigration {
    @Bean
    public FilterRegistrationBean<UserFilter> registrationBean(){
        FilterRegistrationBean<UserFilter> registrationBean=new FilterRegistrationBean<UserFilter>();
        registrationBean.setFilter(new UserFilter());
        registrationBean.addUrlPatterns("/create");
        return registrationBean;
    }
}
