package com.springmongodb.mongo_db.PJO_object;

//to getRequest from API

public class CreateRequest {
    private String name_of_book;
    private String author;
    private int cost;

    public String getName_of_book() {
        return name_of_book;
    }

    public void setName_of_book(String name_of_book) {
        this.name_of_book = name_of_book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public CreateRequest(String name_of_book, String author, int cost) {
        this.name_of_book = name_of_book;
        this.author = author;
        this.cost = cost;
    }

    public CreateRequest() {
    }
}
