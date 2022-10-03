package com.portfolio.Fran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "https://frontendfranh.web.app/")
public class FranApplication {

	public static void main(String[] args) {
		SpringApplication.run(FranApplication.class, args);
	}

}
