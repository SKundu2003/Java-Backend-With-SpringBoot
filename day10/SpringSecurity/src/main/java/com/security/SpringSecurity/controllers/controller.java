package com.security.SpringSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    //this request needed authentication and authorisation
    @GetMapping("/student")
    public String getStudent()
    {
        return "hello Student";
    }
    //this request needed authentication and authorisation
    @GetMapping("/admin")
    public String getAdmin()
    {
        return "hello Admin";
    }

    //this api request don't need any authentication or authorisation
    @GetMapping("/visitor")
    public String visitor()
    {
        return "hello Viewer";
    }
}
