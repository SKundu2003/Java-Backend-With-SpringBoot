package com.example.Application2;

public class userClass {
    private String name;
    private int id;
    private long phone;


    public long getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public userClass(String name, int id,long phone)
    {
        this.name = name;
        this.id = id;
        this.phone = phone;
    }
}
