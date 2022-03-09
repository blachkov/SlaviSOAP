package com.example.producingwebservice;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Film;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class FilmRepository {
	private static final Map<String, Film> films = new HashMap<>();

	@PostConstruct
	public void initData() {
		Film spiderman = new Film();
		spiderman.setName("Spiderman");
		spiderman.setYear(2014);

		films.put(spiderman.getName(), spiderman);

		Film batman = new Film();
		batman.setName("Batman");
		batman.setYear(2010);

		films.put(batman.getName(), batman);

		Film treehouse = new Film();
		treehouse.setName("Tree House");
		treehouse.setYear(2000);

		films.put(treehouse.getName(), treehouse);
	}

	public Film findFilm(String name) {
		Assert.notNull(name, "The film's name must not be null");
		return films.get(name);
	}
}
