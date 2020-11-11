package com.university.register;

import com.university.register.models.Course;
import com.university.register.models.Student;
import com.university.register.repositories.CourseRepository;
import com.university.register.repositories.StudentRepository;
import com.university.register.services.StudentService;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Slf4j
@RestController
public class StudentController {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    StudentController (StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping(value = "student/{id}")
    public Optional<Student> oneStudent(@PathVariable Long id) {
        return this.studentRepository.findById(id);
    }

    @GetMapping(value = "students/{id}/course/{subject}")
    public ResponseEntity<Student> studentEnrolled(@PathVariable Long id, @PathVariable String subject) {
        List<Course> courses = courseRepository.findCourseBySubject(subject);
        if (Objects.isNull(courses)) {
            return ResponseEntity.notFound().build();
        }
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Student s = student.get();
        s.enroll(courses.get(0));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s
            .getId()).toUri();
        return ResponseEntity.created(uri).body(studentRepository.save(s));
    }

    @GetMapping(value = "students/{age}")
    public List<Student> getStudentsOfAge(@PathVariable int age) {
        return studentRepository.findStudentsByAge(age);
    }

    @GetMapping(value = "students")
    public Iterable<Student> allStudents() {
        return studentRepository.findAll();
    }

    @PostMapping(path = "students")
    Student newStudent(@RequestBody Student student) {
        log.info("new student with first name {} created", student.getFirstName());
        return studentRepository.save(student);
    }
}
