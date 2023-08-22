package com.ufcg.es.healthtrack.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDTO {

    private String token;

    public LoginResponseDTO(String jwtToken) {
        this.token = jwtToken;
    }
}
