package com.ufcg.learningjwt.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.WebUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTFilter implements Filter {
	
	private String SECRET_KEY;
	
	@Autowired
    public JWTFilter(String secretKey) {
        this.SECRET_KEY = secretKey;
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        System.out.println(httpRequest.getServletPath());

        if (httpRequest.getServletPath().startsWith("/login")) {
            chain.doFilter(request, response);
            return;
        }

        Cookie token = WebUtils.getCookie(httpRequest, "token");
        
        if (token == null) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        try {

            String jwt = token.getValue();
            System.out.println(SECRET_KEY);

            DecodedJWT decodedJwt = JWT.require(Algorithm.HMAC256(this.SECRET_KEY))
                    .build()
                    .verify(jwt);

            String userEmail = decodedJwt.getClaim("userEmail").asString();
            httpRequest.setAttribute("userEmail", userEmail);

            chain.doFilter(request, response);

        } catch (JWTVerificationException ex) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }
		
	}
}
