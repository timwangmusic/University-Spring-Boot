package com.university.register;

import com.university.register.models.Course;
import com.university.register.repositories.CourseRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
  private final CourseRepository courseRepository;

  @Autowired
  public CourseController(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  @GetMapping("/course/{id}")
  public Optional<Course> GetCourse(@PathVariable Long id) {
    return courseRepository.findById(id);
  }

  @GetMapping("/courses")
  public Iterable<Course> GetAllCourses() {
    return courseRepository.findAll();
  }
}
