package com.shiva.springboot.springSecurity1.Security;

public enum ApplicationUserPermission {

    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");



    private String permissions;



     ApplicationUserPermission(String permissions){

        this.permissions = permissions;
    }


    public String getPermissions() {
        return permissions;
    }





}
