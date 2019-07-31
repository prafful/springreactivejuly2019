package com.springreactive.samples;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxFilters {

	List<String> friends = Arrays.asList("oma", "ana", "keta", "meta");
	
	@Test
	public void fluxFilterTest() {
		
		Flux<String> friendsFlux = Flux.fromIterable(friends)
							.filter(item->item.startsWith("a"))
							.log();
		

		StepVerifier.create(friendsFlux)
					.expectNext("ana")
					.verifyComplete();	
		
	}
	
	@Test
	public void fluxFilterLengthTest() {
		
		Flux<String> friendsFlux = Flux.fromIterable(friends)
							.filter(item->item.length()<4)
							.log();
		

		StepVerifier.create(friendsFlux)
					.expectNext("oma","ana")
					.verifyComplete();	
		
	}
	
}
