package com.shiva.springboot.springSecurity1.Security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.shiva.springboot.springSecurity1.Security.ApplicationUserPermission.*;

public enum ApplicationUserRoles {

    ADMIN(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSE_WRITE,COURSE_READ)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ,STUDENT_READ)),
    STUDENT(Sets.newHashSet(STUDENT_READ));



    private  final Set<ApplicationUserPermission> permissions;


    ApplicationUserRoles(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
