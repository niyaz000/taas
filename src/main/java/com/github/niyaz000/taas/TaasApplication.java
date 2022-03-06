package com.github.niyaz000.taas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TaasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaasApplication.class, args);
	}

}
