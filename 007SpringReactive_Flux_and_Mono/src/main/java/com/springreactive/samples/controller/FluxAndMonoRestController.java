package com.springreactive.samples.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreactive.samples.document.ProductDocument;
import com.springreactive.samples.reactiverepository.MongoDbProductReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.springreactive.samples.constants.*;

@RestController
public class FluxAndMonoRestController {
	
	@Autowired
	private MongoDbProductReactiveRepository mongodbProductReactiveRepository;
	
	@GetMapping("/flux")
	public Flux<Integer> getAllNumbersAsFlux() {
		return Flux.just(1,2,3,4,5,6,7,8,9,10)
				.delayElements(Duration.ofMillis(200))
				.log();
	}
	
	@GetMapping(value = "/fluxstream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Long> getAllNumbersAsFluxStream() {
		return Flux.interval(Duration.ofSeconds(1)).log();
	}
	
	@GetMapping("/mono")
	public Mono<Integer> getMonoForMe() {
		return Mono.just(4).log();
	}
	
	@GetMapping("/get/all")
	public Flux<ProductDocument> getAllProducts() {
		return mongodbProductReactiveRepository.findAll();
	}
	


}
