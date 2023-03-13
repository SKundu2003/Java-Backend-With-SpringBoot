package com.jpa.jpa_gfg;

import com.jpa.jpa_gfg.Database_Reposetory.BookRepository;
import com.jpa.jpa_gfg.Modules.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class JpaGfgApplication { // extends CommandLineRunner

	public static void main(String[] args) {
		SpringApplication.run(JpaGfgApplication.class, args);
	}


	//process of calling a api from comandline
	/*@Autowired
	BookRepository bookRepository;
	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book(1,"master souvik","c with me",100);//with out default constructor it will throw error
		Book book2 = new Book(2,"test name1","bbok1",110);
		ArrayList<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);

//		bookRepository.save(book); //only for one entity

		//several entries at a time
//		bookRepository.saveAll(books); //to save in data base

		//to get from database
		System.out.println(bookRepository.findAll());
	}*/
}
