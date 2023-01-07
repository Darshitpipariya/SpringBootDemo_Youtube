package com.example.springbootdemo_youtube;

import com.example.springbootdemo_youtube.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootDemoYoutubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoYoutubeApplication.class, args);
    }
    @GetMapping("/")
    public List<String> index(){
        return List.of("Hello"," World");
    }

}
