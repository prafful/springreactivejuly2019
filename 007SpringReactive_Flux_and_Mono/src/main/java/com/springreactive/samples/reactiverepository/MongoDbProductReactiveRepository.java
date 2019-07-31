package com.springreactive.samples.reactiverepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springreactive.samples.document.ProductDocument;

public interface MongoDbProductReactiveRepository extends  ReactiveMongoRepository<ProductDocument, String>{

}
