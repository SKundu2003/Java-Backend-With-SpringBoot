package com.MicroServicePractice1.Controllers;

import com.MicroServicePractice1.Entity.ProductEntity;
import com.MicroServicePractice1.Reposetory.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK) //-->this is the replacement of underlying code
//    public List<ProductEntity>getAllProducts(){
////        List<ProductEntity> products = productRepo.findAll();
////        ResponseEntity<List<ProductEntity>> responseEntity = new ResponseEntity<>(products,HttpStatus.OK);
////        return responseEntity;
//
//        return productRepo.findAll();
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProduct(@RequestBody ProductEntity product){
        productRepo.save(product);
    }

}
