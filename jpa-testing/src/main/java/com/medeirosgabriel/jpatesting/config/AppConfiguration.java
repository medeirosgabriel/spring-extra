package com.medeirosgabriel.jpatesting.config;

import com.medeirosgabriel.jpatesting.model.*;
import com.medeirosgabriel.jpatesting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration implements ApplicationRunner {

    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private SportRepository sportRepository;
    @Autowired
    private CoordinatorRepository coordinatorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Parent p1 = new Parent("joao", "pai");
        Parent p2 = new Parent("maria", "mae");
        Coordinator c1 = new Coordinator("Katia");
        Student s1 = new Student("gabriel", p1, c1);
        Student s2 = new Student("jessika", p1);
        Professor pr1 = new Professor("adalgiza");
        Professor pr2 = new Professor("rodolfo");
        Discipline d1 = new Discipline("math");
        Discipline d2 = new Discipline("biology");
        Sport sp1 = new Sport("football");
        Sport sp2 = new Sport("volley");

        s1.addDiscipline(d1);
        s1.addDiscipline(d2);
        s1.addSport(sp1);
        s1.addSport(sp2);
        pr1.addDiscipline(d1);
        pr1.addDiscipline(d2);
        p1.addStudent(s1);
        p2.addStudent(s2);

        parentRepository.save(p1);
        parentRepository.save(p2);
        coordinatorRepository.save(c1);
        disciplineRepository.save(d1);
        disciplineRepository.save(d2);
        professorRepository.save(pr1);
        professorRepository.save(pr2);
        sportRepository.save(sp1);
        sportRepository.save(sp2);
        studentRepository.save(s1);
        studentRepository.save(s2);

        s2.setCoordinator(c1);
        studentRepository.save(s2);
    }
}

