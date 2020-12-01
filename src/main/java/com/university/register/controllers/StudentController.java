package com.university.register.controllers;

import com.university.register.models.AcademicStanding;
import com.university.register.models.Course;
import com.university.register.models.Student;
import com.university.register.services.CourseService;
import com.university.register.services.StudentService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StudentController {

  private final StudentService studentService;
  private final CourseService courseService;

  StudentController(StudentService studentService, CourseService courseService) {
    this.courseService = courseService;
    this.studentService = studentService;
  }

  /** Enroll a student to a course
   * @param id student ID
   * @param subject course subject
   * @return student enrolled to the course
   */
  @GetMapping (value = "/students/{id}/course/{subject}")
  public Student enrollCourse(@PathVariable Long id, @PathVariable String subject) {
    List<Course> courses = courseService.findCourseBySubject(subject);
    if (Objects.isNull(courses) || courses.isEmpty()) {
      log.debug("course not found");
      return new Student();
    }
    Course course = courses.get(0);
    log.info("found course: {}", course);
    return studentService.enrollCourse(id, course).orElse(new Student());
  }


  /**
   * @param academicStanding academic year
   * @return a list of student in the academic year
   */
  @GetMapping(value = "/students/{year}")
  public List<Student> getAllStudents(@PathVariable("year") AcademicStanding academicStanding) {
    return studentService.findStudentsByAcademicStanding(academicStanding);
  }

  /**
   * @return number of students in the university
   */
  @GetMapping(value = "/stats/students/count")
  public Long getStudentCount() {
    return studentService.totalStudentCount();
  }

  /**
   * @return average age of the students in the university
   */
  @GetMapping(value = "/stats/students/avg-age")
  public double getAverageStudentAge() {
    double averageAge = studentService.averageStudentAge();
    BigDecimal roundedAverageAge = new BigDecimal(averageAge).setScale(2, RoundingMode.HALF_UP);
    return roundedAverageAge.doubleValue();
  }
}
