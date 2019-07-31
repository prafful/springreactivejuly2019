package com.springreactive.samples;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoSample {

	/*
	 * @Test public void fluxSample() {
	 * 
	 * Flux<String> stringFlux = Flux.just("OBB", "BNP", "MOW", "PRT") .log();
	 * 
	 * stringFlux.subscribe(System.out::println);
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void fluxSample_WithException() {
	 * 
	 * Flux<String> stringFlux = Flux.just("OBB", "BNP", "MOW", "PRT")
	 * .concatWith(Flux.error(new RuntimeException("Exception Occured from here!")))
	 * .log();
	 * 
	 * stringFlux.subscribe(System.out::println,
	 * (e)->System.err.println("Exception Raised  " + e));
	 * 
	 * 
	 * }
	 */

	
	  @Test public void fluxSample_WithOnComplete() {
	  
	  Flux<String> stringFlux = Flux.just("OBB", "BNP", "MOW", "PRT")
			  				//.concatWith(Flux.error(new RuntimeException("Exception Occured from here!")))
			  				.concatWith(Flux.just("Oota"))
			  				//.concatWith(Flux.just("META"))
			  				.log();
	  
			  				
	  stringFlux = stringFlux.concatWith(Flux.just("META"));
	  
	  stringFlux.subscribe(System.out::println,
	  (e)->System.err.println("Exception Raised  " + e),
	  ()->{System.out.println("On Complete Event Fired");});
	  
	  
	  }
	 

	/*
	 * //Using StepVerifier to assert the flux and its suscription
	 * 
	 * @Test public void fluxSample_TestWithoutError() {
	 * 
	 * Flux<String> stringFlux = Flux.just("OBB", "BNP", "MOW", "PRT")
	 * //.concatWith(Flux.error(new
	 * RuntimeException("Exception Occured from here!")))
	 * .concatWith(Flux.just("Oota")) .log();
	 * 
	 * 
	 * stringFlux.subscribe(System.out::println,
	 * (e)->System.err.println("Exception Raised  " + e),
	 * ()->{System.out.println("On Complete Event Fired");});
	 * 
	 * 
	 * StepVerifier.create(stringFlux) .expectNext("OBB") .expectNext("BNP")
	 * .expectNext("MOW") .expectNext("PRT") .expectNext("Oota") .verifyComplete();
	 * 
	 * 
	 * }
	 * 
	 * @Test public void fluxSample_TestWithError() {
	 * 
	 * Flux<String> stringFlux = Flux.just("OBB", "BNP", "MOW", "PRT")
	 * .concatWith(Flux.error(new RuntimeException("Exception Occured from here!")))
	 * .concatWith(Flux.just("Oota")) .log();
	 * 
	 * 
	 * 
	 * stringFlux.subscribe(System.out::println,
	 * (e)->System.err.println("Exception Raised  " + e),
	 * ()->{System.out.println("On Complete Event Fired");});
	 * 
	 * 
	 * StepVerifier.create(stringFlux) .expectNextCount(4) .expectError() .verify();
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

}
