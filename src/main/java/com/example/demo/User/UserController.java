package com.example.demo.User;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/find")
    public String findUser(@RequestParam String name){
        return "<h1>Searching user named: "+name+"....</h1>o";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        return service.getUser(id);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestParam String name){
        User user= service.createUser(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
