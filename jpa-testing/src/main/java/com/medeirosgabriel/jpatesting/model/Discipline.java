package com.medeirosgabriel.jpatesting.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToMany(mappedBy="disciplines", cascade = CascadeType.ALL)
    private List<Student> students;

    public Discipline(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
}
