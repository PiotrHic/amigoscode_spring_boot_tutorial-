package com.example.amigoscode_spring_boot_tutorial.controllers;

import com.example.amigoscode_spring_boot_tutorial.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    @GetMapping("")
    public List<Student> getStudents(){
        return List.of(new Student(
                1L,
                "Piotr Hic",
                "hicu@wp.pl",
                25,
                LocalDate.of(1991, Month.SEPTEMBER,17)));
    }

}
