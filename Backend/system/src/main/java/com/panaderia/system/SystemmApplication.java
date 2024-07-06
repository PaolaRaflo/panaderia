package com.panaderia.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.panaderia.system")
@EnableJpaRepositories("com.panaderia.system.repository")
public class SystemmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemmApplication.class, args);
	}

}
