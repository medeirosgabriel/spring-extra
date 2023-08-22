package com.ufcg.learningjwt.config;

import com.ufcg.learningjwt.login.JWTFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Bean
    public FilterRegistrationBean<JWTFilter> jwtFilter() {
        FilterRegistrationBean<JWTFilter> jwtFilter = new FilterRegistrationBean<JWTFilter>();
        jwtFilter.setFilter(new JWTFilter(SECRET_KEY));
        jwtFilter.addUrlPatterns("/*");
        return jwtFilter;
    }
}
