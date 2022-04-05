package com.shiva.springboot.springSecurity1.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v2/students")
public class StudentController {

   static List<Student>  students = Arrays.asList(
           new Student(1,"Shiva"),
           new Student(2,"parvathi"),
           new Student(3,"shankara"),
           new Student(4,"mahadevva"),
           new Student(5,"govinda")


   );

@GetMapping(path = "{studentId}")
public  Student getStudent(@PathVariable("studentId") Integer studentId){

    Student student = students.stream().filter(
             temp->studentId.equals(temp.getStudentId())

    ).findFirst()
            .orElseThrow(()->new IllegalStateException("student id "+studentId+" not found"));


   return student;
}


}
