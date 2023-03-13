package spring_with_jdbc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring_with_jdbc.DAOs.Persons;
import spring_with_jdbc.DBmanager.DB_Operations;
import spring_with_jdbc.Requests.CreateRequest;

import java.net.CacheRequest;
import java.sql.SQLException;
import java.util.List;

@RestController
public class PersonController {
    @GetMapping("/getAllUsers")
    public List<Persons> getAllUsers() throws SQLException {
        //Calling DAOs to get object from DB
        return DB_Operations.getPersons();
    }

    @PostMapping("/insertPerson")
    //Requests.CreateRequest clas will get a (PJO)-->plain java object
    public void insertPerson(@RequestBody CreateRequest request) throws SQLException {
        DB_Operations.insertPerson(request);
    }
}
