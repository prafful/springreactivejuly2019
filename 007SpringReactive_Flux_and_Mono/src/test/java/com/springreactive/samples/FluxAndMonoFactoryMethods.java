package com.springreactive.samples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoFactoryMethods {
	
	List<String> friends = Arrays.asList("oma", "ana", "ket", "met");

	@Test
	public void fluxFactoryMethods_Iterator() {
		Flux<String> friendsFlux =  Flux.fromIterable(friends)
									.log();
		
	StepVerifier.create(friendsFlux)
//			.expectNext("oma")
//			.expectNext("ana")
//			.expectNext("ket")
//			.expectNext("met")
			.expectNext("oma", "ana", "ket", "met")
			.verifyComplete();
		
	}
	
	
	@Test
	public void fluxFactoryMethods_Array() {
		
		String[] friends = new String[] {"oma", "ana", "ket", "met"};
		
		Flux<String> friendsFlux =  Flux.fromArray(friends)
									.log();
		
	StepVerifier.create(friendsFlux)
//			.expectNext("oma")
//			.expectNext("ana")
//			.expectNext("ket")
//			.expectNext("met")
			.expectNext("oma", "ana", "ket", "met")
			.verifyComplete();
		
	}
	
	@Test
	public void fluxFactoryMethods_Stream() {
		
		
		
		Flux<String> friendsFlux =  Flux.fromStream(friends.stream())
									.log();
		
	StepVerifier.create(friendsFlux)
//			.expectNext("oma")
//			.expectNext("ana")
//			.expectNext("ket")
//			.expectNext("met")
			.expectNext("oma", "ana", "ket", "met")
			.verifyComplete();
		
	}
	
	@Test
	public void monoTest() {
		Mono<Object> monoNull =   Mono.justOrEmpty(null)
								.log();
		
		StepVerifier.create(monoNull)
				.verifyComplete();
	}
	
	@Test
	public void monoWithOneValue() {
		
		Supplier<String> stringSupplier = ()->"oma";
		
		Mono<String> monoString = Mono.fromSupplier(stringSupplier)
									.log();
		
		System.out.println(stringSupplier.get());
		
		StepVerifier.create(monoString)
					.expectNext("oma")
					.verifyComplete();
		
		
	}
	
	@Test
	public void createFluxFromRange() {
		Flux<Integer> numberFlux =  Flux.range(1,10).log();
		
		StepVerifier.create(numberFlux)
			.expectNext(1,2,3,4,5,6,7,8,9,10)
			.verifyComplete();
	}
	
	
	
	
}
