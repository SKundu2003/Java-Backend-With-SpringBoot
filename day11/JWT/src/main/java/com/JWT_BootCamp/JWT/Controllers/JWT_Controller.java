package com.JWT_BootCamp.JWT.Controllers;

import com.JWT_BootCamp.JWT.Models.JwtRequestObject;
import com.JWT_BootCamp.JWT.Models.JwtResponce;
import com.JWT_BootCamp.JWT.Services.CustomUserServices;
import com.JWT_BootCamp.JWT.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JWT_Controller {

    //to authenticate the user
    @Autowired
    private AuthenticationManager authenticationManager; //bean declared in "jwt_config"
    //now we have to validate "JwtRequestObject" object
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    CustomUserServices customUserServices;
    @PostMapping("/generateToken")
    //question mak means it can return anything
    public ResponseEntity<JwtResponce> geneateToken(@RequestBody JwtRequestObject jwtRequestObject)
    {
        //this will authenticate the username and password
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(jwtRequestObject.getUserName(), jwtRequestObject.getPassword());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //to get the userDetails
        UserDetails userDetails = customUserServices.loadUserByUsername(jwtRequestObject.getUserName());
        String jwtToken = jwtUtil.generateToken(userDetails);

//        passing the sting to get the responce
        JwtResponce jwtResponce = new JwtResponce(jwtToken); //-->dowing this to pass java objcet to the browser so that can be translated to json

        //now returning the Java object of "jwtResponce"
        return new ResponseEntity<JwtResponce>(jwtResponce, HttpStatus.OK);
    }
}
