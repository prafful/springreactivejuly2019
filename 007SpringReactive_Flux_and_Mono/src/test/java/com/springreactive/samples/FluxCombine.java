package com.springreactive.samples;

import java.time.Duration;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxCombine {
	
	@Test
	public void combineFlux() {
		 Flux<String> names1 =  Flux.just("oma", "ola", "neto","oma1", "ola1", "neto1");
		 Flux<String> names2 =  Flux.just("pma", "kla", "zeto","pma1", "kla1", "zeto1");
		 
		 Flux<String> names = Flux.merge(names1, names2);
		 
		 Flux<String> namesConcat = Flux.concat(names1, names2);
		 
		 StepVerifier.create(names.log())
		 			.expectSubscription()
		 			.thenAwait(Duration.ofSeconds(4))
		 			.expectNextCount(12)
		 			.verifyComplete();
		 
		 StepVerifier.create(namesConcat.log())
			.expectNextCount(12)
			.verifyComplete();
	}

}
