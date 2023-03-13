package com.jpa.jpa_gfg.JPA_joins.Controller;

import com.jpa.jpa_gfg.JPA_joins.Database_Reposetory.BookRepository;
import com.jpa.jpa_gfg.JPA_joins.Modules.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class bookController {
    @Autowired
    BookRepository bookRepository;
    @GetMapping("/getAllUsers")
    public ArrayList<Book> getAllUsers() {
        return (ArrayList<Book>) bookRepository.findAll();
    }
    @PostMapping("/enterNewUser")
    public void enterNewUser(@RequestBody Book obj)
    {
        bookRepository.save(obj);
    }
    @GetMapping("/findById")
    public Book findById(@RequestParam int id)
    {
        return bookRepository.getReferenceById(id);
    }
    @GetMapping("/findByAuthor_SQL")
    public List<Book> findByAuthor_SQL(@RequestParam String name)
    {
        return bookRepository.getListOfAllbooks_By_Using_Author_Name(name);

    }
    @GetMapping("/findByAuthor_JPQL")
    public List<Book> findByAuthor_JPQL(@RequestParam String name)
    {
        return bookRepository.findBookUsingAuthor(name);
    }
}
