package com.springreactive.samples;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxMap {
	
	List<String> friends = Arrays.asList("oma", "ana", "keta", "meta");
	
	/*
	 * @Test public void transformFluxWithMap() {
	 * 
	 * Flux<String> friendsFlux = Flux.fromIterable(friends) .map(item->
	 * item.toUpperCase()) .log();
	 * 
	 * StepVerifier.create(friendsFlux) .expectNext("OMA","ANA", "KETA", "META")
	 * .verifyComplete(); }
	 * 
	 * @Test public void getFluxLengthWithMap() {
	 * 
	 * Flux<Integer> friendsFluxLength = Flux.fromIterable(friends) .map(item->
	 * item.length()) .log();
	 * 
	 * StepVerifier.create(friendsFluxLength) .expectNext(3,3, 4, 4)
	 * .verifyComplete(); }
	 * 
	 * @Test public void getFluxLengthOfFilteredWithMap() {
	 * 
	 * Flux<Integer> friendsFluxLength = Flux.fromIterable(friends) .filter(item ->
	 * item.length() < 4 ) .map(item-> item.length()) .log();
	 * 
	 * StepVerifier.create(friendsFluxLength) .expectNext(3,3) .verifyComplete(); }
	 * 
	 * @Test public void getFluxRepeat() {
	 * 
	 * Flux<Integer> friendsFluxRepeat = Flux.fromIterable(friends) .map(item->
	 * item.length()) .repeat(2) .log();
	 * 
	 * StepVerifier.create(friendsFluxRepeat) .expectNextCount(12)
	 * .verifyComplete(); }
	 */
	
	@Test
	public void fluxWithFlatMap() {
		Flux<String> friendsFlux = Flux.fromIterable(friends)
					.flatMap(  item -> {
						System.out.println(item);
						return Flux.fromIterable(getFromList(item));
					}).log();

		StepVerifier.create(friendsFlux)
					.expectNextCount(8)
					.verifyComplete();
		
	}
	
	private List<String> getFromList(String item){
		
		return Arrays.asList(item, "abcd");
	}
	
	


}
