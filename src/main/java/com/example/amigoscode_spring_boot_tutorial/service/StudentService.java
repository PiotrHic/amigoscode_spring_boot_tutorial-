package com.example.amigoscode_spring_boot_tutorial.service;

import com.example.amigoscode_spring_boot_tutorial.model.Student;
import com.example.amigoscode_spring_boot_tutorial.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
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
                findStudentsByEmail(newStudent.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        studentRepository.save(newStudent);
    }

    // patrz to or else throw - mega skrot do wywolywania wyjatkow
    @Transactional
    public void updateStudent(Long studentId, String name, String email){

        // znajduje studenta po id
        Student student = studentRepository.findById(studentId).orElseThrow( () -> new IllegalStateException(
                "student with id " + studentId + " does not exists!"
        ));

        // Jesli imie nie jest to samo, setuje to imie

        if(name != null &
                name.length() > 0 &&
        !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        // to samo, dodatkowo waliduje czy juz sie taki email nie znajduje

        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository
                    .findStudentsByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }

    public void deleteStudent(Long studentId){
        boolean exists =  studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("studen with id " + studentId + " does not exist in database");
        }
        studentRepository.deleteById(studentId);
    }
}
