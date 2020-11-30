package com.university.register.services;

import com.university.register.models.Course;
import com.university.register.repositories.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
  private final CourseRepository courseRepository;
  @Autowired
  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public List<Course> findCourseBySubject(String subject) {
    return courseRepository.findCourseBySubject(subject);
  }
}
