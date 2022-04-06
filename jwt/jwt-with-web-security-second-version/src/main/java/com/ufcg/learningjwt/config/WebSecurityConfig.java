package com.ufcg.learningjwt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ufcg.learningjwt.login.JWTAuthenticationFilter;
import com.ufcg.learningjwt.login.JWTLoginFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	private static final String USERS_QUERY =  "SELECT email, '{noop}' || password, 'true' AS enabled FROM user WHERE email=?";
	private static final String AUTHORITIES =  "SELECT email, 'ROLE_USER' FROM user WHERE email=?";
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.antMatchers(HttpMethod.POST, "/users").permitAll()
			.antMatchers("/h2-console/*").permitAll()
			.anyRequest().authenticated()
			.and()
			
			// Filter login requests
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
			
			// Filter others requests to verify the JWT presence in the header
			.addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery(USERS_QUERY)
	        .authoritiesByUsernameQuery(AUTHORITIES);
	}
}
