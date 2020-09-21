package com.stanford.register.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findStudentsByAge(@Param("age") int age);
}
