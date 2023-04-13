package com.example.redistest.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor //work as constructors
@NoArgsConstructor
@RedisHash("Product") //to use redis
public class Product {
    @Id
    private int id;
    private String name;
    private int quantity;
    private float price;
}
