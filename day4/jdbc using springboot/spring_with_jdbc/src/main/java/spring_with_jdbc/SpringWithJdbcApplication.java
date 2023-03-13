package spring_with_jdbc;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

@SpringBootApplication
public class SpringWithJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithJdbcApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	}

}
