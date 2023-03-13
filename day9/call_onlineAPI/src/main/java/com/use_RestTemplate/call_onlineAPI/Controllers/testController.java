package com.use_RestTemplate.call_onlineAPI.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class testController{
//    @Autowired
//    RestTemplate restTemplate; //best alternative --> WebClient
    @GetMapping("/hi")
    public String hello()
    {
        return "hello world";
    }
}
