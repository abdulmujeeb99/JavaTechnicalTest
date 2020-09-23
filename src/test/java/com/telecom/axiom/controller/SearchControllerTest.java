package com.telecom.axiom.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.telecom.axiom.model.*;

import com.telecom.axiom.AxiomApplicationTests;

public class SearchControllerTest extends AxiomApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private UriComponentsBuilder uriComponentsBuilder;

	private String serviceUrl = "/axiom/mobile/search";

	@BeforeEach
	public void beforeEachTest() {
		uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(
				new StringBuilder("http://localhost:").append(port).append(serviceUrl).toString());
	}

	@Test
	void testSearchMobileByPriceEur() throws Exception {
		uriComponentsBuilder.queryParam("priceEur", 200);
		ResponseEntity<Mobile[]> responseEntity = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), Mobile[].class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Mobile[] response = responseEntity.getBody();		
		assertEquals(10, response.length);
	}
	
	@Test
	void testSearchMobileBySim() throws Exception {
		uriComponentsBuilder.queryParam("sim", "eSim");
		ResponseEntity<Mobile[]> responseEntity = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), Mobile[].class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Mobile[] response = responseEntity.getBody();		
		assertEquals(18, response.length);
	}
	
	@Test
	void testSearchMobileByannounceDateAndpriceEur() throws Exception {
		uriComponentsBuilder.queryParam("announceDate", "1999");
		uriComponentsBuilder.queryParam("priceEur", 200);
		ResponseEntity<Mobile[]> responseEntity = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), Mobile[].class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Mobile[] response = responseEntity.getBody();		
		assertEquals(2, response.length);
	}

}
