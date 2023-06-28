package com.taskmanager.taskmanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);

	}

}
// http://localhost:8080/swagger-ui/index.html#/Usuario/findById endpoint para swagger
