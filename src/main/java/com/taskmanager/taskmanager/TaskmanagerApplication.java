package com.taskmanager.taskmanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class TaskmanagerApplication {

	private Logger logger = Logger.getLogger(TaskmanagerApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);

	}

	@GetMapping
	public String helloWorld(){
		return "Olá mundo, teste!";
	}
}
// http://localhost:8080/swagger-ui/index.html#/Usuario/findById endpoint para swagger
