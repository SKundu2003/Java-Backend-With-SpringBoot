package com.example.Application2;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
    private int lId;
    private String brand;


    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lId=" + lId +
                ", brand='" + brand + '\'' +
                '}';
    }
    public void compile(){
        System.out.println("hello this is a compiler");
    }
}
