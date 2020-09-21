package com.stanford.register.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String subject;
  private int credit;

  public Course(String subject, int credit) {
    this.subject = subject;
    this.credit = credit;
  }

  protected Course() {
  }

  @Override
  public String toString() {
    return String.format("Course: %s with %d credit", this.subject, this.credit);
  }
}
