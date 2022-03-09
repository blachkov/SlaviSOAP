
package com.example.consumingwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.GetFilmRequest;
import com.example.consumingwebservice.wsdl.GetFilmResponse;

public class FilmClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(FilmClient.class);

	public GetFilmResponse getFilm(String film) {

		GetFilmRequest request = new GetFilmRequest();
		request.setName(film);

		log.info("Requesting location for " + film);

		GetFilmResponse response = (GetFilmResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/films", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetFilmRequest"));

		return response;
	}

}
