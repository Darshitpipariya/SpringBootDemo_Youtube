package com.example.springbootdemo_youtube.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
// business logic at service layer

// make Component using annotation @Controller for object creation using spring controller.  Spring IOC and Dependency injection to work
// we are using @Service annotation instead of @Controller both are same but @Service is specific to Service layer class it is given by spring boot.
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(@Autowired StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }
}
