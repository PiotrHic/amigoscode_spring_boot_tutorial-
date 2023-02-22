package com.example.amigoscode_spring_boot_tutorial.repositories;

import com.example.amigoscode_spring_boot_tutorial.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Wybrac z database
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentsByEmail(String email);
}
