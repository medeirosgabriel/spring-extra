package com.ufcg.learningjwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.ufcg.learningjwt.login.JWTFilter;

@SpringBootApplication
public class LearningJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningJwtApplication.class, args);
	}
}
