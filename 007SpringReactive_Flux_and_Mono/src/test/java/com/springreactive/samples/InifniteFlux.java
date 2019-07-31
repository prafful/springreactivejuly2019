package com.springreactive.samples;

import java.time.Duration;

import org.junit.Test;

import reactor.core.publisher.Flux;

public class InifniteFlux {
	
	@Test
	public void infiniteFluxTest() throws InterruptedException {
		Flux<Long> infiniteMilliFlux = Flux.interval(Duration.ofMillis(10000))
									.log();
		
		infiniteMilliFlux.subscribe( item -> System.out.println(item));
		
		//Thread.sleep(1000);
		
	}

}
