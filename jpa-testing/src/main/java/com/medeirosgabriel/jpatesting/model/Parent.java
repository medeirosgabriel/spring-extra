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
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String kinship;
    @OneToMany(mappedBy = "parent")
    private List<Student> students;

    public Parent(String name, String kinship) {
        this.name = name;
        this.students = new ArrayList<>();
        this.kinship = kinship;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
