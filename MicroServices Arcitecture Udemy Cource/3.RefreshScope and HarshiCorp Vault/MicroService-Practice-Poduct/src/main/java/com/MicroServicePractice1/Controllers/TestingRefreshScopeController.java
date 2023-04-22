package com.MicroServicePractice1.Controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
@RefreshScope //this will refresh all the "@Value" data in the bean after "/actuator/refresh" is called -->POST endpoint
public class TestingRefreshScopeController {

    @Value("${product.value}")
    private String productValue;

    @GetMapping("/productValue")
    public String getProductValue()
    {
        return this.productValue;
    }
}
