package com.ufcg.learningjwt.resource;

import java.util.Optional;

import javax.security.auth.login.CredentialException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ufcg.learningjwt.model.Credentials;
import com.ufcg.learningjwt.model.User;
import com.ufcg.learningjwt.service.UserService;

@Controller
@RequestMapping(value = "/login")
public class LoginResource {
	
	@Autowired
	private UserService userService;
	
	@Value("${jwt.secret}")
	private String SECRET_KEY;
	
	@PostMapping
	@ResponseBody
	public void login(@RequestBody Credentials credentials, HttpServletResponse response) throws CredentialException {
		
		Optional<User> maybeUser = this.userService.findUserById(credentials.getEmail());
		
        if (!maybeUser.isPresent()) {
        	throw new CredentialException(); 
        }
        
        User user = maybeUser.get();
        
        if (!user.getPassword().equals(credentials.getPassword())) {
        	 throw new CredentialException();
        } else {
        	System.out.println(this.SECRET_KEY);
        	String jwt = JWT.create().withClaim("userEmail", user.getEmail())
        			 				  .sign(Algorithm.HMAC256(this.SECRET_KEY));

            Cookie cookie = new Cookie("token", jwt);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            cookie.setMaxAge(60 * 5); // 5 minutes
            response.addCookie(cookie);
        }
	}
}
