package com.stanford.register.demo;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

  private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo(StudentRepository repository) {
    return (args -> {
      repository.save(new Student(1L, "Tommy", "Yang", 20));
      repository.save(new Student(2L, "Katie", "Q", 9));
      repository.save(new Student(3L, "Sandeep", "Johnson", 12));

      List<Student> studentList = repository.findStudentsByAge(12);
      for (Student student : studentList) {
        logger.info(student.toString());
      }
    });
  }
}
