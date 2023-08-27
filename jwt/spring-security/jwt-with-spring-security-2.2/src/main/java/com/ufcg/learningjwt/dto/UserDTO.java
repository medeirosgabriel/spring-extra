package com.ufcg.learningjwt.dto;

import com.ufcg.learningjwt.model.Role;
import lombok.Data;
import java.util.Set;

@Data
public class UserDTO {

    private String email;
    private String name;
    private String password;
    private String roleName;
}
