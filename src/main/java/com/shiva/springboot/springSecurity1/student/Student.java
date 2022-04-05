package com.shiva.springboot.springSecurity1.student;

public class Student {


    private String name;

    private Integer studentId;

    public Student(Integer studentId,String name) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}
