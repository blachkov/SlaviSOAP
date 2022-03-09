package com.example.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetFilmRequest;
import io.spring.guides.gs_producing_web_service.GetFilmResponse;

@Endpoint
public class FilmEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private FilmRepository filmRepository;

	@Autowired
	public FilmEndpoint(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFilmRequest")
	@ResponsePayload
	public GetFilmResponse getFilm(@RequestPayload GetFilmRequest request) {
		GetFilmResponse response = new GetFilmResponse();
		response.setFilm(filmRepository.findFilm(request.getName()));

		return response;
	}
}
