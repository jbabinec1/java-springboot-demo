package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
           Student jared = new Student("Jared", "Jared@email.com", 31, LocalDate.of(1993, Month.JULY, 19));
           Student bob = new Student("bob", "bob@email.com", 31, LocalDate.of(1993, Month.AUGUST, 20));

           repository.saveAll(
                   List.of(jared, bob)
           );
        };
    }
}
