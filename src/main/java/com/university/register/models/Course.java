package com.university.register.models;

import com.sun.istack.Nullable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
