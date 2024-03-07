package com.medeirosgabriel.jwtapp.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
    private String email;
    private String password;
}
