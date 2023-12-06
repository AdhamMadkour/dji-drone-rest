package com.task.djidronerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DjiDroneRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DjiDroneRestApplication.class, args);
	}

}
