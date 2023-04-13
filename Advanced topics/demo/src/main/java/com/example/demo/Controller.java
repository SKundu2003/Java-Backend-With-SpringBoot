package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class Controller {
    @GetMapping("/")
    public RedirectView home(Model model) {
        RedirectView view = new RedirectView();
        view.setUrl("http://localhost:8080/index.html");
        return view;
    }
}
