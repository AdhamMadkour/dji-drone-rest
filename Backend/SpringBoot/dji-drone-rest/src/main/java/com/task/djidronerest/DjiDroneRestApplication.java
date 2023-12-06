package com.task.djidronerest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@OpenAPIDefinition(
		info = @io.swagger.v3.oas.annotations.info.Info(
				title = "DJI Drone REST API",
				version = "1.0",
				description = "DJI Drone REST API"
		)
)
@EnableScheduling
public class DjiDroneRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DjiDroneRestApplication.class, args);
	}

}
