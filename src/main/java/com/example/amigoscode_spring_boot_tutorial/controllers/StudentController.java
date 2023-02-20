package com.example.amigoscode_spring_boot_tutorial.controllers;

import com.example.amigoscode_spring_boot_tutorial.model.Student;
import com.example.amigoscode_spring_boot_tutorial.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }


}
