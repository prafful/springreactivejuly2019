package com.springreactive.samples;

import org.junit.Test;

import reactor.core.publisher.Flux;

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
	
	@Test
	public void fluxSample_WithException() {
		
		Flux<String> stringFlux = Flux.just("OBB", "BNP", "MOW", "PRT")
								.concatWith(Flux.error(new RuntimeException("Exception Occured!")))
								.log();
		
		stringFlux.subscribe(System.out::println, 
								(e)->System.err.println(e));
		
		
	}


}
