package com.securityjpa.springsecurityusingjpa;

import com.securityjpa.springsecurityusingjpa.DAO.UserDetailObject;
import com.securityjpa.springsecurityusingjpa.Jpa_Repo.UserReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SpringSecurityUsingJpaApplication {
	@Autowired
	UserReposetory userReposetory;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityUsingJpaApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		UserDetailObject user1 = new UserDetailObject("souvik","test","admin");
//		UserDetailObject user2 = new UserDetailObject("gopal","test","student");
//		userReposetory.save(user1);
//		userReposetory.save(user2);
//	}
}
