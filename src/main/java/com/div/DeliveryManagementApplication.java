package com.div;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = {"com.div" , "com.div.mapper"})
public class DeliveryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryManagementApplication.class, args);
	}

}
