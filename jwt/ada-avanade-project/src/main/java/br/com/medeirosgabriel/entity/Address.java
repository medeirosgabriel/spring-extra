package br.com.medeirosgabriel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private User user;
    private String street;
    private long number;
    private String district;
    private String city;
    private String postalCode;
    private String state;
    private String country;
    private String complement;
}
