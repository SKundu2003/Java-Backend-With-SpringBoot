package com.Producer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Configuration
public class KafkaProducer {
    @Autowired//using kafka template to send data in kafka topic
    private KafkaTemplate<String ,String > kafkaTemplate;

    @Value("${kafka.topic-value}") //defined in appliaction properties
    private String kafkaTopic;

    //creating a method to send data to kafka topic --> using the kafka template
    public String sendMessage(String message){
        kafkaTemplate.send(kafkaTopic,message);
        return "Message passed successfully in kafka topic";
    }

}
