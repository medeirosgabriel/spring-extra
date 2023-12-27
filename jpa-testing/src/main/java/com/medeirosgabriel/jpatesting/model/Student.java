package com.medeirosgabriel.jpatesting.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "student_discipline",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    private List<Discipline> disciplines;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToMany
    @JoinTable(name = "student_sport",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_id"))
    private List<Sport> sports;

    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    private Coordinator coordinator;

    public Student(String name, Parent parent) {
        this.name = name;
        this.disciplines = new ArrayList<>();
        this.sports = new ArrayList<>();
        this.parent = parent;
    }

    public Student(String name, Parent parent, Coordinator coordinator) {
        this.name = name;
        this.disciplines = new ArrayList<>();
        this.sports = new ArrayList<>();
        this.parent = parent;
        this.coordinator = coordinator;
    }

    public void addDiscipline(Discipline d) {
        this.disciplines.add(d);
    }

    public void addSport(Sport s) {
        this.sports.add(s);
    }

}
