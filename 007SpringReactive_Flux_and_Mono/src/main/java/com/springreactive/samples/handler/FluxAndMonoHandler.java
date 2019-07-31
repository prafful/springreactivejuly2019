package com.springreactive.samples.handler;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FluxAndMonoHandler {

	public Mono<ServerResponse> getAllFlux(ServerRequest serverRequest) {
		return ServerResponse
					.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(
							Flux.just(1,2,3,4).log(), 
							Integer.class);
	}
	
	public Mono<ServerResponse> getAllFluxStream(ServerRequest serverRequest) {
		return ServerResponse
					.ok()
					.contentType(MediaType.APPLICATION_STREAM_JSON)
					.body(
							Flux.interval(Duration.ofSeconds(1)).log(), 
							Long.class);
	}
}
