package com.example.amigoscode_spring_boot_tutorial.service;

import com.example.amigoscode_spring_boot_tutorial.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return List.of(new Student(
                1L,
                "Piotr Hic",
                "hicu@wp.pl",
                25,
                LocalDate.of(1991, Month.SEPTEMBER,17)));
    }
}
