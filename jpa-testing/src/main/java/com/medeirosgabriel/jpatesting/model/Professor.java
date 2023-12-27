package com.medeirosgabriel.jpatesting.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "professor_id")
    private List<Discipline> disciplines;

    public Professor(String name) {
        this.name = name;
        this.disciplines = new ArrayList<>();
    }

    public void addDiscipline(Discipline d) {
        this.disciplines.add(d);
    }
}
