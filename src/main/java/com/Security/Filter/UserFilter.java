package com.Security.Filter;

import com.Security.Models.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.util.Map;

@Component
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("I am inside filter.");
        HttpServletRequest httpServletReq=(HttpServletRequest) request;

        System.out.println(httpServletReq.getMethod());
//        System.out.println(httpServletReq.getInputStream().readAllBytes());
//        System.out.println(httpServletReq.);
//        System.out.println(httpServletReq.getRequestURI());
//        System.out.println(httpServletReq.getServletPath());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
