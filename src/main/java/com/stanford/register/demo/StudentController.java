package com.stanford.register.demo;

import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    StudentController (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(value = "students")
    public String one(@Param("id") Long id) {
        return this.studentRepository.findById(id).toString();
    }

    @PostMapping(path = "students")
    Student newStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
