package com.university.register.models;

import com.sun.istack.Nullable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NonNull
  private Long id;
  @NonNull
  private String subject;
  @NonNull
  private int credit;
  @Nullable
  private String description;

  @Override
  public String toString() {
    return String.format("%s (%d credit)", this.subject, this.credit);
  }
}
