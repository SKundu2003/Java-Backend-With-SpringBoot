package com.jpabeans.jpabeans_class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired  //dependency injection

    HelloWorld helloWorld;

//    @Qualifier(value = "helloWorld")
//    private HelloWorld helloWorld;

    @GetMapping("/func")
    public void func() {
        System.out.println(helloWorld);
    }
}
