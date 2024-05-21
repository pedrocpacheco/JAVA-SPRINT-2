package br.com.fiap.anallyzer.apianallyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiAnallyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAnallyzerApplication.class, args);
	}

}
