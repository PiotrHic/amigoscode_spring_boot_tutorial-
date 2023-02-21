package com.example.amigoscode_spring_boot_tutorial.repositories;

import com.example.amigoscode_spring_boot_tutorial.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
