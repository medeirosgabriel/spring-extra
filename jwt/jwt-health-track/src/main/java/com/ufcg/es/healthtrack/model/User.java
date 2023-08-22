package com.ufcg.es.healthtrack.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String email;
    private String name;
    private String password;

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
}
