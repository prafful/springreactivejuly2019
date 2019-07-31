package com.springreactive.samples.setup;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springreactive.samples.document.ProductDocument;
import com.springreactive.samples.reactiverepository.MongoDbProductReactiveRepository;

import reactor.core.publisher.Flux;

@Component
public class ProductDataSetup implements CommandLineRunner {
	
	@Autowired
	private MongoDbProductReactiveRepository mongodbProductReactiveRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		setupInitialData();
		
	}
	
	List<ProductDocument> dataSource(){
		return Arrays.asList(
				new ProductDocument(null, "Cap", 88.1),
				new ProductDocument(null, "Hat", 44.1),
				new ProductDocument(null, "Mat", 80.1),
				new ProductDocument(null, "Oat", 53.1)
				);
	}
	
	private void setupInitialData(){
		mongodbProductReactiveRepository.deleteAll()
				.thenMany(Flux.fromIterable(dataSource()))
				.flatMap(mongodbProductReactiveRepository::save)
				.subscribe( item ->{
					System.out.println("Item inserted: " + item);
				});
	}

}
