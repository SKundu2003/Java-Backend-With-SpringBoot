package com.example.Application2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class controller {


    //GET Api examples


    @GetMapping("/search")
    public String surchResult(@RequestParam String q){
        return "your quary is "+q;
    }
    @GetMapping("/youtube")
    public String searchWeb()throws Exception
    {
        URL url = new URL("https://www.youtube.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }
    DBuserData dBuserData = new DBuserData();
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK) //sending the responce status
    public ArrayList<userClass> getAllusers()
    {
        return dBuserData.getAllUsers();
    }

    //path variable
    @GetMapping("/users/{id}") //to get id as input
    public userClass getOneUser(@PathVariable int id)
    {
        return dBuserData.getOneUserDetail(id);
    }



    //POST api examples
    @PostMapping("/newUser")
    public userClass enterNewUser(@RequestBody userClass user) {
        return dBuserData.addNewUser(user.getName(), user.getId(), user.getPhone());
    }

    @DeleteMapping("/user/delete/{id}")
    public boolean deleteAuser(@PathVariable Integer id){
        return dBuserData.deleteAuser(id);
    }
}
