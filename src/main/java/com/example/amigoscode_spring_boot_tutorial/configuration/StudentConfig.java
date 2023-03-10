package com.example.amigoscode_spring_boot_tutorial.configuration;

import com.example.amigoscode_spring_boot_tutorial.model.Student;
import com.example.amigoscode_spring_boot_tutorial.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    //anymous class xd wywalone id, bo to powinno byc autogenerated przez database
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args ->{
            Student piotrHic = new Student(
                    "Piotr Hic",
                    "hicu@wp.pl",
                LocalDate.of(1991, Month.SEPTEMBER,17)
            );

            Student igorKotelko = new Student(
                    "Igor Kotelko",
                    "kotel@wp.pl" ,
                    LocalDate.of(1991, Month.SEPTEMBER,9)
            );

            studentRepository.saveAll(
                    List.of(piotrHic, igorKotelko)
            );
        };
    }
}
