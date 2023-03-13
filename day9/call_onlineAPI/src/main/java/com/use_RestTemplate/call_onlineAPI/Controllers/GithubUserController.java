package com.use_RestTemplate.call_onlineAPI.Controllers;


import com.use_RestTemplate.call_onlineAPI.Json_To_Java_object.GitHub_All_parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class GithubUserController {
    @Autowired
    RestTemplate restTemplate; //best alternative --> WebClient

    @RequestMapping("/user")
    public GitHub_All_parameters getGitHubUserInfo(@RequestParam String name)
    {
        ResponseEntity<GitHub_All_parameters> responseEntity = restTemplate.getForEntity(String.format("https://api.github.com/users/%s",name), GitHub_All_parameters.class);
        return responseEntity.getBody();
    }
}
