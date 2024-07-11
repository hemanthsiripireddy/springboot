package com.hemanth.demo.rest;

import com.hemanth.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students = new ArrayList<>();

    @PostConstruct
    public void postConstruct() {


        students.add(new Student("hemanth", "siripireddy"));
        students.add(new Student("sai", "siripireddy"));
        students.add(new Student("mywife", "siripireddy"));

    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId >= students.size() || studentId < 0)
            throw new StudentNotFoundException("Student not found with Id: " + studentId);

        return students.get(studentId);

    }

    @GetMapping("/students")
    public List<Student> getStudents() {


        return students;

    }


}
