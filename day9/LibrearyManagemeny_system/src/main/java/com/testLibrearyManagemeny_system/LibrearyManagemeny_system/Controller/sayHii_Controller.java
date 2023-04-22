package com.use_RestTemplate.LibrearyManagemeny_system.src.main.java.com.testLibrearyManagemeny_system.LibrearyManagemeny_system.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
public class sayHii_Controller {
    @GetMapping("/")
    public String hi()
    {
        return "test";
    }
}
