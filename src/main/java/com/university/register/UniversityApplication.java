package com.university.register;

import com.university.register.models.AcademicStanding;
import com.university.register.models.Course;
import com.university.register.models.Student;
import com.university.register.repositories.CourseRepository;
import com.university.register.repositories.StudentRepository;
import java.util.HashMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniversityApplication {
  public static void main(String[] args) {
    SpringApplication.run(UniversityApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo(StudentRepository studentRepository, CourseRepository courseRepository) {
    return (args -> {
      studentRepository.save(new Student(1L, "Tommy", "Yang",
          20, AcademicStanding.JUNIOR, new HashMap<>()));
      studentRepository.save(new Student(2L, "Katie", "Q",
          19, AcademicStanding.JUNIOR, new HashMap<>()));
      studentRepository.save(new Student(3L, "Dwayne", "Johnson",
          20,AcademicStanding.SENIOR, new HashMap<>()));

      // seeding the course repository
      courseRepository.save(new Course(1L, "math", 5, "basic math skills"));
      courseRepository.save(new Course(2L, "chinese", 6, "fundamental Chinese"));
    });
  }
}
