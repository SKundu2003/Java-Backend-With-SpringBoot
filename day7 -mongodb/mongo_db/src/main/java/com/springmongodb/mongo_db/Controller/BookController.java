package com.springmongodb.mongo_db.Controller;

import com.springmongodb.mongo_db.Modules.Book;
import com.springmongodb.mongo_db.PJO_object.CreateRequest;
import com.springmongodb.mongo_db.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @GetMapping("/getAllusers")
    public List<Book> getAllUsers()
    {
        return bookRepository.findAll();
    }

    @PostMapping("/insertBook")
    public void insertBook(@RequestBody CreateRequest createRequest)
    {
        Book book = new Book(createRequest.getName_of_book(),createRequest.getAuthor(),createRequest.getCost());
        bookRepository.save(book);
    }

    //using Request parameter
    @GetMapping("/getBookByAuthorName")
    public List<Book> getBookByAuthorName(@RequestParam(value = "name") String name)
    {
        return bookRepository.findByAuthor(name);
    }

    //using PathVariable
    @GetMapping("/getBookByAuthorName/{name}")
    public List<Book> getBookByAuthorNameByPath(@PathVariable(value = "name") String name)
    {
        return bookRepository.findByAuthor(name);
    }
}
