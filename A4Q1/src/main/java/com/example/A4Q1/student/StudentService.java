package com.example.A4Q1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> student1 = studentRepository.findStudentByEmail(student.getEmail());
        if(student1.isPresent()){
            throw new IllegalArgumentException("Email Taken");
        }
        studentRepository.save(student);
    }

    public void removeStudent(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()){
            throw new IllegalArgumentException("Email Taken");
        }
        studentRepository.deleteById(id);
    }

    public void updateStudentEmail(Integer id, String email){
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()){
            throw new IllegalArgumentException("Email Taken");
        }

        student.ifPresent(student1 -> {
            student1.setEmail(email);
            studentRepository.save(student1);
        });

    }


}
