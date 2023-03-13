package com.jpa.jpa_gfg.JPA_joins.Modules;


import jakarta.persistence.*;

@Entity //only then hibernate will change the object into data //and store in DB
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;


    private String name;
    private String authr;
    private int prise;
    @ManyToOne
    @JoinColumn //this will include autometacally with the primary key of the table "BookCatagory"
    private BookCatagory bookCatagory;

    public Book(String name, String authr, int prise) {
        this.name = name;
        this.authr = authr;
        this.prise = prise;
    }

    //soluction
    public Book() {
    }

    //new constructor with new paramiter "bookCatagory"


    public Book(String name, String authr, int prise, int bookCatagory) {
        this.name = name;
        this.authr = authr;
        this.prise = prise;
         this.bookCatagory = new BookCatagory();
        this.bookCatagory.setId(bookCatagory);
    }

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

    public String getAuthr() {
        return authr;
    }

    public void setAuthr(String authr) {
        this.authr = authr;
    }

    public int getPrise() {
        return prise;
    }

    public void setPrise(int prise) {
        this.prise = prise;
    }

    //getter and setter for "bookCatagory"


    public BookCatagory getBookCatagory() {
        return bookCatagory;
    }

    public void setBookCatagory(BookCatagory bookCatagory) {
        this.bookCatagory = bookCatagory;
    }

    @Override
    public String toString() {
        return "name is " + this.getName()+" author is "+this.getAuthr();
    }
}
