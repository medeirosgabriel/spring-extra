package com.ufcg.es.healthtrack.service;

import com.ufcg.es.healthtrack.filter.JWTFilter;
import com.ufcg.es.healthtrack.dto.CredentialsDTO;
import com.ufcg.es.healthtrack.dto.LoginResponseDTO;
import com.ufcg.es.healthtrack.exceptions.InvalidCredentialsException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

    public static final String TOKEN_KEY = "asdfasdfasdfsfdsawaer";

    @Autowired
    private UserService userService;

    public LoginResponseDTO authenticate(CredentialsDTO credentials) throws InvalidCredentialsException {

        validateUser(credentials);
        String token = createToken(credentials);

        return new LoginResponseDTO(token);
    }

    private void validateUser(CredentialsDTO credentialsDTO) {
        if (!this.userService.validateUser(credentialsDTO.getEmail(), credentialsDTO.getPassword())){
            throw new InvalidCredentialsException("Invalid Credentials.");
        }
    }

    private String createToken(CredentialsDTO credentialsDTO) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(credentialsDTO.getEmail())
                .signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .compact();
    }

    public String getEmailLoggedUser(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new SecurityException("Inexist Token or Bad Token!");
        }

        // Extraindo apenas o token do cabecalho.
        String token = authorizationHeader.substring(JWTFilter.TOKEN_INDEX);

        String subject = null;
        try {
            subject = Jwts.parser().setSigningKey(TOKEN_KEY).parseClaimsJws(token).getBody().getSubject();
        } catch (SignatureException e) {
            throw new SecurityException("Invalid Token or Expired Token!");
        }
        return subject;
    }
}
