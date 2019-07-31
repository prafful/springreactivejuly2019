package com.springreactive.samples;

import java.time.Duration;

import org.junit.Test;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class HotAndColdFlux {
	
	@Test
	public void coldFluxTest() throws InterruptedException {
		Flux<String> coldFLux = Flux.just("A","B","C","D","E","F","G","H","I","J","K")
								.delayElements(Duration.ofMillis(500));
		
		coldFLux.subscribe(a -> System.out.println("Subscriber 1: " + a));
		
		Thread.sleep(500);
		
		coldFLux.subscribe(a -> System.out.println("Subscriber 2: " + a));
		
		Thread.sleep(4000);
		
	}
	
	
	  @Test public void hotFluxTest() throws InterruptedException { 
		  
		  Flux<String> hotFLux = Flux.just("A","B","C","D","E","F","G","H","I","J","K")
				  					.delayElements(Duration.ofMillis(1000));
	  
	    ConnectableFlux<String> connectableHotFlux = hotFLux.publish();
	    connectableHotFlux.connect();
	    
	    connectableHotFlux.subscribe(item -> System.out.println("Sub 1: " + item));
	    Thread.sleep(3000);
	    connectableHotFlux.subscribe(item -> System.out.println("Sub 2: " + item));
	    Thread.sleep(4000);
	  
		  
		 
	
	  
	  }
	 

}
