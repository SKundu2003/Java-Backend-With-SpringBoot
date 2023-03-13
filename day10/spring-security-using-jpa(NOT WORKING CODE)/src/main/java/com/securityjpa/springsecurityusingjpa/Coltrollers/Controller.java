package com.securityjpa.springsecurityusingjpa.Coltrollers;

import com.securityjpa.springsecurityusingjpa.DAO.UserDetailObject;
import com.securityjpa.springsecurityusingjpa.Jpa_Repo.UserReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    UserReposetory userReposetory;
    //this request needed authentication and authorisation
    @GetMapping("/student")
    public String getStudent() {
        return "hello Student";
    }

    //this request needed authentication and authorisation
    @GetMapping("/admin")
    public String getAdmin() {
        return "hello Admin";
    }

    //this api request don't need any authentication or authorisation
    @GetMapping("/visitor")
    public String visitor() {
        return "hello Viewer";
    }

    @PostMapping("/create")
    public void CreateNewUser(@RequestBody UserDetailObject userDetailObject)
    {
        userReposetory.save(userDetailObject);
    }
}
