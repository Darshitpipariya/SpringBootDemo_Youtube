package com.example.springbootdemo_youtube.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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

    public void addStudent(Student student) {
        Optional<Student> studentOptional =studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new RuntimeException("email already used");
        }
        //if not taken then save it
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
        boolean flag=studentRepository.existsById(studentId);
        if(!flag){
            throw new RuntimeException("student with id "+studentId+" does not exist");
        }
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student=studentRepository.findById(studentId)
                .orElseThrow(()->new RuntimeException("student with id "+studentId+" does not exist"));

        if(name!=null &&
                name.length()>0 &&
        !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email!=null &&
        email.length()>0 &&
        !Objects.equals(student.getEmail(),email)){
            student.setEmail(email);
        }


    }
}
