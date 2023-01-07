package com.example.springbootdemo_youtube.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repositry of data access layer
// repositry is for student table and it key is of type Long
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
