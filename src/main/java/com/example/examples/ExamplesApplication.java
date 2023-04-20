package com.example.examples;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.examples.services.BeersService;
import com.example.examples.services.TdbService;

@SpringBootApplication
public class ExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamplesApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner getDataFromRest(BeersService beersService, TdbService tdbService) {
		return (args) -> {
			beersService.getBeersFromApi();
			tdbService.getQuestionsFromApi();
		};
	}


}
