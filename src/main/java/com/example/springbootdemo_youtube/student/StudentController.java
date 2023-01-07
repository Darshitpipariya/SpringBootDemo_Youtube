package com.example.springbootdemo_youtube.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// controller for rest api end points
//here we need service object for that we are using Spring dependency injection as we have made service as spring component using @Sercice annotation.

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    // using dependency injection for Student sercvice inilization
    public StudentController(@Autowired StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }
}
