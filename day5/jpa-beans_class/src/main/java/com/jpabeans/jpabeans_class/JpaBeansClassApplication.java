package com.jpabeans.jpabeans_class;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JpaBeansClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaBeansClassApplication.class, args);

		//just for demonstration purpos dont need to create a AnnotationConfigApplicationContext object.
		//otherwise we cant access @Bean in ouw web api

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(MyConfig.class);
//		context.refresh();
//
//		//geting the object //singleton scope //by default
//		HelloWorld obj1 = context.getBean(HelloWorld.class);
//		obj1.setMsg("msg1");
//		obj1.setData("Data1");
//		HelloWorld obj2 = context.getBean(HelloWorld.class); //only one object is created
//		obj2.setMsg("msg2");
//		obj2.setData("Data2");
//		System.out.println(obj1);
//		System.out.println(obj2);

	}

}
