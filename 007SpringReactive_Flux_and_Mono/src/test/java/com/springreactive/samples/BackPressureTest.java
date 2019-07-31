package com.springreactive.samples;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class BackPressureTest {
	
	@Test
	public void backPressureSample() {
		
		Flux<Integer> finiteNumberFlux = Flux.range(1,  10)
									.log();
		
		finiteNumberFlux.subscribe(item -> System.out.println(item),
				e -> System.err.println("Exception is: " + e),
				() -> System.out.println("Completed"),
				subscription -> subscription.request(5));
		
	}
	
	@Test
	public void backPressureSampleTest() {
		
		Flux<Integer> finiteNumberFlux = Flux.range(1,  10)
									.log();
		
		/*
		 * finiteNumberFlux.subscribe(item -> System.out.println(item), e ->
		 * System.err.println("Exception is: " + e), () ->
		 * System.out.println("Completed"), subscription -> subscription.request(5));
		 */
		
		StepVerifier.create(finiteNumberFlux)
				.expectSubscription()
				.thenRequest(1)
				.expectNext(1)
				.thenRequest(2)
				.expectNext(2)
				.expectNext(3)
				.expectNext(4)
				.expectNext(5)
				.thenCancel()
				.verify();
		
	}


}
