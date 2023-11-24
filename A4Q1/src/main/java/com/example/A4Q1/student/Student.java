package com.example.A4Q1.student;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="students")
public class Student {
    @Id
    @SequenceGenerator(
            name = "students_student_id_seq",
            sequenceName = "students_student_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "students_student_id_seq"
    )
    private Integer student_id;
    private String first_name;
    private String last_name;
    private String email;
    private LocalDate enrollment_date;

    public Student() {
    }

    public Student(int student_id, String first_name, String last_name, String email, LocalDate enrollment_date) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.enrollment_date = enrollment_date;
    }

    public Student(String first_name, String last_name, String email, LocalDate enrollment_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.enrollment_date = enrollment_date;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(LocalDate enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", enrollment_date=" + enrollment_date +
                '}';
    }
}
