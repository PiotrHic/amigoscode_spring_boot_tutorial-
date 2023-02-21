package com.example.amigoscode_spring_boot_tutorial.service;

import com.example.amigoscode_spring_boot_tutorial.model.Student;
import com.example.amigoscode_spring_boot_tutorial.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        // czyli wywoluje wszystko, co zostalo
        return studentRepository.findAll();
    }

//    public List<Student> getStudents(){
//        return List.of(new Student(
//                1L,
//                "Piotr Hic",
//                "hicu@wp.pl",
//                25,
//                LocalDate.of(1991, Month.SEPTEMBER,17)));
//    }
}
