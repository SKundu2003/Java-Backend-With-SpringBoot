package com.springmongodb.mongo_db.Repository;

import com.springmongodb.mongo_db.Modules.Book;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Configuration
public interface BookRepository extends MongoRepository<Book,Integer> {
    public List<Book> findByAuthor(String name);
}
