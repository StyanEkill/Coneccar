package com.api.Coneccar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConeccarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConeccarApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Hello World";
	}

}
