package com.example.amigoscode_spring_boot_tutorial;

import com.example.amigoscode_spring_boot_tutorial.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class AmigoscodeSpringBootTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmigoscodeSpringBootTutorialApplication.class, args);
    }

    @GetMapping("/")
    public List<Student> hello(){
        return List.of(new Student(
                1L,
                "Piotr Hic",
                "hicu@wp.pl",
                25,
                LocalDate.of(1991, Month.SEPTEMBER,17)));
    }

}
