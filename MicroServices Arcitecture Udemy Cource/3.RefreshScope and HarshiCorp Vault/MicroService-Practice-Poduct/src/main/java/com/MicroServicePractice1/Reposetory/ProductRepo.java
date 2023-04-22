package com.MicroServicePractice1.Reposetory;

import com.MicroServicePractice1.Entity.ProductEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

@Configuration
public interface ProductRepo extends MongoRepository<ProductEntity,String> {
}
