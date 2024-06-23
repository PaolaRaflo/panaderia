package com.panaderia.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.panaderia.system")
public class SystemmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemmApplication.class, args);
	}

}
