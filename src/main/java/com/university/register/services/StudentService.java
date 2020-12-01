package com.university.register.services;

import com.sun.istack.Nullable;
import com.university.register.models.AcademicStanding;
import com.university.register.models.Course;
import com.university.register.models.Student;
import com.university.register.repositories.StudentRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Optional<Student> enrollCourse(@NonNull Long studentId, @NonNull Course course) {
    Optional<Student> student = studentRepository.findById(studentId);
    if (student.isPresent()) {
      Student currentStudent = student.get();
      currentStudent.getCourses().put(course, course);
      studentRepository.save(currentStudent);
    } else {
      log.debug("student not found");
    }
    return student;
  }

  public long totalStudentCount() {
    return studentRepository.count();
  }

  public Double averageStudentAge() {
    Iterable<Student> studentIterator = studentRepository.findAll();
    return StreamSupport.stream(studentIterator.spliterator(), false).collect(
        Collectors.averagingInt(Student::getAge));
  }

  public List<Student> findStudentsByAcademicStanding(@Nullable AcademicStanding academicStanding) {
    return studentRepository.findStudentsByAcademicStanding(academicStanding);
  }
}
