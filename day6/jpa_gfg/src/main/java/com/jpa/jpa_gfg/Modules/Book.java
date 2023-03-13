package com.jpa.jpa_gfg.Modules;


import jakarta.persistence.*;
import org.hibernate.annotations.Generated;

@Entity //only then hibernate will change the object into data //and store in DB

//to change the table name use "@Table"
//@Table(name = "my_book_table") //this may create a new table named "my_book_table" -->bacause it already has a table names book
public class Book {

    @Id //for primary key
    //to auto incriment ID using hibernate
//    @GeneratedValue(strategy = GenerationType.AUTO) //so we dont need to give ID every time
    private int id;


//    @Column(name = "name_of_book") //to change the column name use --> "@Column"
    private String name;
//    @Column(name = "name_of_author")
    private String authr;
    private int prise;

    //in spring if parameterised constructor is created then the default constructor is overloaded
//it means "Books()"(default constructor) we need to create beacuse hibernate need to create a object for initialising
//and with out a default constructor hibernate can't create a Object,to connect with the database
    public Book(int id, String name, String authr, int prise) {
        this.id = id;
        this.name = name;
        this.authr = authr;
        this.prise = prise;
    }

    //soluction
    public Book() {
    }

    ;

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

    @Override
    public String toString() {
        return "name is " + this.getName()+" author is "+this.getAuthr();
    }
}
