package com.Consumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    //new thing //Message type object to read message from kafka topic
    //and we need to tell kafka that it's our consumer or listener
    @KafkaListener(topics = "${kafka.topic-value}")
    public void listenMessage(Message<String> message){
        System.out.println(message.getPayload());
    }
}
