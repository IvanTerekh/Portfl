package com.terekh.portfl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AopConfiguration.class)
public class PortflApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortflApplication.class, args);
	}
}
