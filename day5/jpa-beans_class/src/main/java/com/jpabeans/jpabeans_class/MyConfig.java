package com.jpabeans.jpabeans_class;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration //most important for @Autowired
//@ComponentScan("com.jpabeans.jpabeans_class")
 public class MyConfig {

//    @Scope("prototype")  -->if we do this then singleton scope will not in use
    //its just line normal this  -->> HelloWorld obj = new HelloWorld();

    //so dont use @Scope("prototype")
    @Bean
    public HelloWorld getHelloWorldObject() {
        return new HelloWorld("this is message","this is data");
    }
}
