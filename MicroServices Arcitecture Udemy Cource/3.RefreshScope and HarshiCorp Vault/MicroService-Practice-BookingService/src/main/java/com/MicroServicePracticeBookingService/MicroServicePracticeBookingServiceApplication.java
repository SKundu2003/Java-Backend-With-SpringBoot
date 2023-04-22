package com.MicroServicePracticeBookingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServicePracticeBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicePracticeBookingServiceApplication.class, args);
	}

}
