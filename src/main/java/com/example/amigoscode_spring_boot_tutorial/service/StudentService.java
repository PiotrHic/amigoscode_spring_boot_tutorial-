package com.example.amigoscode_spring_boot_tutorial.service;

import com.example.amigoscode_spring_boot_tutorial.model.Student;
import com.example.amigoscode_spring_boot_tutorial.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

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
    // jest walidacja i jest optional, poczytaj o optional!
    public void addNewStudent(Student newStudent) {
        Optional<Student> studentOptional = studentRepository.
                findStudentsById(newStudent.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        studentRepository.save(newStudent);
    }

    public void deleteStudent(Long studentId){
        boolean exists =  studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("studen with id " + studentId + " does not exist in database");
        }
        studentRepository.deleteById(studentId);
    }
}
