package com.university.register.repositories;

import com.university.register.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findStudentsByAge(@Param("age") int age);
    List<Student> findStudentsByFirstName(@Param("firstName") String firstname);
}
