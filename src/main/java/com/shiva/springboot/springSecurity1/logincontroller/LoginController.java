package com.shiva.springboot.springSecurity1.logincontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {


    @GetMapping("login")
    public String logInView(){

        return "login";
    }

    @GetMapping("courses")
    public String showCourses(){

        return "courses";
    }
}
