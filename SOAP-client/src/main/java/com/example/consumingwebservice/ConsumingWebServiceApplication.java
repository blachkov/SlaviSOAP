
package com.example.consumingwebservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.consumingwebservice.wsdl.GetFilmResponse;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(FilmClient quoteClient) {
		return args -> {
			String film = "Tree House";

			if (args.length > 0) {
				film = args[0];
			}
			GetFilmResponse response = quoteClient.getFilm(film);
			System.err.println(response.getFilm().getName());
			System.err.println(response.getFilm().getYear());
		};
	}

}
