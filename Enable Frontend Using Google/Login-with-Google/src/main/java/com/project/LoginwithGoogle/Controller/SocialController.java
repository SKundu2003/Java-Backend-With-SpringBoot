package com.project.LoginwithGoogle.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class SocialController {
    @GetMapping("/great")
    public String greatUser(){
        return "Hello User";
    }

    //only needed user details
    @GetMapping("/userDetails")
    public Map<String,Object> getAlldetailsOfUser(@AuthenticationPrincipal OAuth2User user){
        return user.getAttributes();
    }


    //return all details
    @GetMapping("/grtPrincipal")
    public Principal getUserPrincipal(Principal principal){
        return principal;
    }
}
