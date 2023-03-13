package com.use_RestTemplate.call_onlineAPI.Config_class;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplate_config {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
