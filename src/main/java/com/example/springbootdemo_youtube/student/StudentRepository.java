package com.example.springbootdemo_youtube.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// repositry of data access layer
// repositry is for student table and it key is of type Long
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
//    @Query("SELECT S FROM Student s where s.email=?1")   this query will execute for below function or we can specify the Query using @Qurery tag
//    @Query("SELECT S FROM Student s where s.email=?1")
    Optional<Student> findStudentByEmail(String email);

}
