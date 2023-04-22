package com.groupmessageusingwebsocket.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //to maintain web socket
public class WebSocketConfigurations implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //providing the url where the user will connect to the server
        // for creating connectivity client need to hit this endpoint
        registry.addEndpoint("/server-url").withSockJS();//using SocketJs to connect to the server
    }



    //Message broker for --> send and recive message
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");//enabling the broker from the "/topic" url

        //client will send the message first at this url
        registry.setApplicationDestinationPrefixes("/app");
    }
}
