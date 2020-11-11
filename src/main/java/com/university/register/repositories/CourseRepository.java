package com.university.register.repositories;

import com.university.register.models.Course;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends CrudRepository<Course, Long> {
  List<Course> findCourseBySubject(@Param("subject") String subject);
}
