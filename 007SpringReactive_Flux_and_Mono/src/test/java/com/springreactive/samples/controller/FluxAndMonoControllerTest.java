package com.springreactive.samples.controller;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ListBodySpec;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@WebFluxTest
public class FluxAndMonoControllerTest {

	@Autowired
	WebTestClient webTestClient;
	
	@Test
	public void getAllNumbersAsFluxTest() {
		
		Flux<Integer> numberFlux =  webTestClient.get().uri("/flux")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange()
				.expectStatus()
				.isOk()
				.returnResult(Integer.class)
				.getResponseBody();
		
		StepVerifier.create(numberFlux)
				.expectSubscription()
				.expectNext(1)
				.expectNext(2)
				.expectNext(3)
				.expectNext(4)
				.expectNext(5)
				.expectNext(6)
				.expectNext(7)
				.expectNext(8)
				.expectNext(9)
				.expectNext(10)
				.verifyComplete();
					
		
	}
	
	/*
	 * @Test public void getAllNumbersAsFluxLengthTest() {
	 * 
	 * EntityExchangeResult<List<Integer>> numberFlux =
	 * webTestClient.get().uri("/flux") .accept(MediaType.APPLICATION_JSON_UTF8)
	 * .exchange() .expectStatus() .isOk()
	 * .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
	 * .expectBodyList(Integer.class) .hasSize(10).returnResult();
	 * 
	 * assertEquals(numberFlux, Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	 * 
	 * 
	 * }
	 */
	
}
