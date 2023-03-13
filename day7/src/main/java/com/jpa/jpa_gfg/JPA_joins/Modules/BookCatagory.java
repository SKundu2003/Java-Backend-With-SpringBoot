package com.jpa.jpa_gfg.JPA_joins.Modules;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class BookCatagory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;


    @OneToMany(mappedBy = "bookCatagory",cascade = CascadeType.ALL,fetch = FetchType.EAGER) //fetch type is very importent
    //for maping --> with out "fetch = FetchType.EAGER" --> JPA will not get the maped data
    private Set<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public BookCatagory() {
    }
    //constructor for book catagory standalone --> only the bookCatagory ,No book

    public BookCatagory(String name) {
        this.name = name;
    }

    //with books

    public BookCatagory(String name, Set<Book> books) {
        this.name = name;
        this.books = books;

        //this is very import
        //to set the bookCatagory ID for beach book
        this.books.forEach(x->x.setBookCatagory(this)); //short way
        //long way--->>
//        Iterator i = books.iterator();
//        while (i.hasNext()){
//            Book book = (Book) i.next();
//            book.setBookCatagory(this);
//        }

    }
}
