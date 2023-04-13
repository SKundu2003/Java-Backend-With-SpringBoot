package com.example.Application2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(Application2Application.class, args);
		test obj = context.getBean(test.class);
		obj.show();
	}

}
