package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements SomeService{

    @Override
    public String greet() {
        return "this is my message for primary";
    }
}
