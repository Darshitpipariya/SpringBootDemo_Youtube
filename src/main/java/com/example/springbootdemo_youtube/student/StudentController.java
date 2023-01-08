package com.example.springbootdemo_youtube.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,@RequestParam(required = true) String name,@RequestParam(required = true) String email){
        studentService.updateStudent(studentId,email,name);
    }
}
