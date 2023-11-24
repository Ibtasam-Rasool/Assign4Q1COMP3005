package com.example.A4Q1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{student_id}")
    public void deleteStudent(@PathVariable("student_id") Integer student_id){
        studentService.removeStudent(student_id);
    }

    @PutMapping(path = "{student_id}")
    public void updateStudentEmail(@PathVariable("student_id") Integer student_id, @RequestBody Map<String, String> email)
    {

        studentService.updateStudentEmail(student_id, email.get("email"));
    }



}
