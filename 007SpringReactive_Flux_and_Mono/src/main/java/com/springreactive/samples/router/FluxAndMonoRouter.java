package com.springreactive.samples.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.springreactive.samples.handler.FluxAndMonoHandler;

@Configuration
public class FluxAndMonoRouter {

	@Bean
	public RouterFunction<ServerResponse> myRoutes(FluxAndMonoHandler fluxAndMonoHandler) {
		
		return RouterFunctions.route(RequestPredicates
										.GET("/functional/flux")
											.and(RequestPredicates
													.accept(MediaType.APPLICATION_JSON)), 
									fluxAndMonoHandler::getAllFlux)
								.andRoute(RequestPredicates.GET("/functional/stream")
										    .and(RequestPredicates
										    		.accept(MediaType.APPLICATION_JSON)), 
									fluxAndMonoHandler::getAllFluxStream); 
	}
	
}
