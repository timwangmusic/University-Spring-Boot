package com.university.register.models;

import com.sun.istack.Nullable;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NonNull
  private Long id;
  @NonNull
  private String firstName;
  @NonNull
  private String lastName;
  @NonNull
  private int age;
  @NonNull
  private AcademicStanding academicStanding;
  @OneToMany
  @Nullable
  private Map<Course, Course> courses;

  @Override
  public String toString() {
    return String.format("Student %d, name is %s %s", this.id, this.firstName, this.lastName);
  }
}
