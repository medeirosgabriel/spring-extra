package com.ufcg.learningjwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.ufcg.learningjwt.login.JWTFilter;

@SpringBootApplication
public class LearningJwtApplication {
	
	@Value("${jwt.secret}")
	private String SECRET_KEY;
	
	@Bean
	public FilterRegistrationBean<JWTFilter> jwtFilter() {
		FilterRegistrationBean<JWTFilter> jwtFilter = new FilterRegistrationBean<JWTFilter>();
		jwtFilter.setFilter(new JWTFilter(SECRET_KEY));
		jwtFilter.addUrlPatterns("/*");
		return jwtFilter;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearningJwtApplication.class, args);
	}
}
