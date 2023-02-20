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

public class AmigoscodeSpringBootTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmigoscodeSpringBootTutorialApplication.class, args);
    }

}
