package com.medeirosgabriel.jwtapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotNull(message = "Email is mandatory") @NotBlank(message = "Email is mandatory")
    private String email;
    @NotNull(message = "Password is mandatory") @NotBlank(message = "Password is mandatory")
    private String password;
    @NotNull(message = "Name is mandatory") @NotBlank(message = "Name is mandatory")
    private String name;
    private Integer age;
}
