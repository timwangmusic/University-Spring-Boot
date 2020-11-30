package com.university.register.repositories;

import com.university.register.models.AcademicStanding;
import com.university.register.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findStudentsByAcademicStanding(AcademicStanding academicStanding);
}
