package com.jpa.jpa_gfg.JPA_joins;

import com.jpa.jpa_gfg.JPA_joins.Database_Reposetory.BookCatagoryRepository;
import com.jpa.jpa_gfg.JPA_joins.Database_Reposetory.BookRepository;
import com.jpa.jpa_gfg.JPA_joins.Modules.Book;
import com.jpa.jpa_gfg.JPA_joins.Modules.BookCatagory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaGfgApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaGfgApplication.class, args);
	}
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookCatagoryRepository bookCatagoryRepository;
	@Override
	public void run(String... args) throws Exception {
		Set<Book> books = new HashSet<>();

//		Book book1 = new Book("c with me","master souvik",100);//with out default constructor it will throw error
//		Book book2 = new Book("Python","Lee",400);
		Book test_Book = new Book("java","souvik",500);
//		books.add(book1);
//		books.add(book2);
		bookRepository.save(test_Book);
//		bookRepository.save(book2);



		//creating a book catagory without any book
//		bookCatagoryRepository.save(new BookCatagory("Non Programming Book"));

		//creating a bookCatagory with some books
//		bookCatagoryRepository.save(new BookCatagory("Programming Books",books));
	}
}
