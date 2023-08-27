package com.ufcg.learningjwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufcg.learningjwt.model.Credentials;
import com.ufcg.learningjwt.service.TokenAuthenticationService;
import com.ufcg.learningjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTLoginFilter  extends OncePerRequestFilter {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;
	private RequestMatcher myMatcher = new AntPathRequestMatcher("/login");

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return !this.myMatcher.matches(request);
	}

	@Override
	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {

		Credentials credentials = new ObjectMapper()
				.readValue(request.getInputStream(), Credentials.class);

		UserDetails user = this.userService.loadUserByUsername(credentials.getEmail());
		Authentication auth = new UsernamePasswordAuthenticationToken(
				credentials.getEmail(),
				credentials.getPassword(),
				user.getAuthorities()
		);

		System.out.println(user.getUsername() + " " + user.getPassword());

		authenticationManager.authenticate(auth);

		String token = tokenAuthenticationService.getToken(auth.getName());
		Map<String, String> body = new HashMap<>();
		body.put("token", token);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonBody = objectMapper.writeValueAsString(body);
		response.getWriter().write(jsonBody);
	}
}
	
