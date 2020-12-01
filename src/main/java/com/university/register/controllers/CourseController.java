package com.university.register.controllers;

import com.university.register.models.Course;
import com.university.register.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
  private final CourseRepository courseRepository;

  @Autowired
  public CourseController(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  @GetMapping("/courses")
  public Iterable<Course> GetAllCourses() {
    return courseRepository.findAll();
  }

  @GetMapping("/course/{id}")
  public Course GetCourse(@PathVariable Long id) {
    return courseRepository.findById(id).orElse(new Course());
  }

  @PostMapping("/courses")
  public Course CreateCourse(@RequestBody Course course) {
    return courseRepository.save(course);
  }
}
