package com.example.amigoscode_spring_boot_tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class AmigoscodeSpringBootTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmigoscodeSpringBootTutorialApplication.class, args);
    }

    @GetMapping("/")
    public List<String> hello(){
        return List.of("Hello", "World");
    }

}
