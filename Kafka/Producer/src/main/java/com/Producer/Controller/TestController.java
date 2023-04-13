package com.Producer.Controller;


import com.Producer.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private KafkaProducer kafkaProducer;
    @GetMapping("/publish")
    public String publishMessage(@RequestParam("msg") String msg){
        return kafkaProducer.sendMessage(msg);
    }
}
