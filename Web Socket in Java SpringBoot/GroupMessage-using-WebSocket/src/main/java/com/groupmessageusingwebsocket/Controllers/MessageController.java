package com.groupmessageusingwebsocket.Controllers;

import com.groupmessageusingwebsocket.Models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @MessageMapping("/message") //any client will send message to this url //one person will send
    @SendTo("/topic/send-to-all") //every client who subscribed this url will recive the message //every person will recive
    public Message getContent(@RequestBody Message message) throws InterruptedException {
        Thread.sleep(100);
        return message;
    }
}
