package com.shiva.springboot.springSecurity1.student;

import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getStudents(){

        return students;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void addStudent(@RequestBody Student student){



    }

    @PutMapping("{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable Integer studentId,@RequestBody Student student){


    }

    @DeleteMapping("{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable Integer studentId){


    }
}
