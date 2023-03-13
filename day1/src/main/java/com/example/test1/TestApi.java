package com.example.test1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
//    @GetMapping("/")
//    public String defaultValue(){
//        return "index page";
//    }
    @GetMapping("/test")
    public String outputTest(){
        return "Hello world, this is a test";
    }
    @GetMapping("/search")
    public String searchResult(@RequestParam String quary)
    {
        sampleData obj = new sampleData();
        return obj.getValue(quary);
    }
}
