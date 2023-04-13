package com.example.test.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class HomeControllers {
    @GetMapping("/test")
    public String helloWorld()
    {
        return "hello world";
    }
    @GetMapping("/")
    public RedirectView ShowIndex(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("index.html");
        return redirectView;
    }
    @PostMapping("/api")
    public String receiveInput(@RequestBody Map<String,String> payload) {
        String input = payload.get("input");
        return "Received input: ";
    }

}
