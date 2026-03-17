package com.example.demo.User;


import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class UserService {
    private final Map<Integer,User> users= new HashMap<>();
    private int currId=1;

    public User createUser(String name){
        User user= new User(currId++,name);
        users.put(user.getId(),user);
        return user;
    }
    public User getUser(int id){
        return new User(id,"krihsna");
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }
}
