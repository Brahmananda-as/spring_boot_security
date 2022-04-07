package com.shiva.springboot.springSecurity1.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v2/students")
public class StudentManagementController {

    static List<Student> students = Arrays.asList(
            
            new Student(1,"Shiva"),
            new Student(2,"parvathi"),
            new Student(3,"shankara"),
            new Student(4,"mahadevva"),
            new Student(5,"govinda")


    );

    @GetMapping()
    public List<Student> getStudents(){

        return students;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){



    }

    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable Integer studentId,@RequestBody Student student){


    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable Integer studentId){


    }
}
