package com.example.amigoscode_spring_boot_tutorial.controllers;

import com.example.amigoscode_spring_boot_tutorial.model.Student;
import com.example.amigoscode_spring_boot_tutorial.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerNewStudent(@RequestBody Student newStudent){
        studentService.addNewStudent(newStudent);
    }

    @DeleteMapping(path= "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

//    @Transactional
    @PutMapping("{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

}
