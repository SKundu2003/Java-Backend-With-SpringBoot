package com.JWT_BootCamp.JWT.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {
    @GetMapping
    public String sayHelloToAll()
    {
        return "hello user how are you";
    }
    @GetMapping("/test")
    public String testingEndpoint()
    {
        return "test API";
    }
}
