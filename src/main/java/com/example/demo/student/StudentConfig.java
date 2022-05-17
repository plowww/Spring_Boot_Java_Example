package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    // Some example students to start with. Rest can be added via API requests
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student kevin = new Student(
                "Kevin",
                "koiven@gmail.com",
                LocalDate.of(1990,Month.APRIL,4));
            
            Student arnold = new Student(
                "Arnold",
                "aschwarz@gmail.com",
                LocalDate.of(1980,Month.APRIL,4)
            );

            repository.saveAll(
                List.of(kevin,arnold)
            );
        };
    }
}
