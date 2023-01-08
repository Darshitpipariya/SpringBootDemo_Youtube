package com.example.springbootdemo_youtube.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student darshit=new Student("darshit", LocalDate.of(2000,7,22),"darhsit2272000@gmail.com");
            Student vivek=new Student("vivek", LocalDate.of(2003,6,12),"darhsit22072000@gmail.com");
            Student savan=new Student("savan", LocalDate.of(2000,4,11),"darhsit220072000@gmail.com");
            Student hiren=new Student("hiren", LocalDate.of(1999,12,14),"darhsit2270002000@gmail.com");
            repository.saveAll(
                    List.of(darshit,vivek,savan,hiren)
            );
        };

    }
}
