package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appling")
public class HelloController {
//    @Autowired
    private final SomeService service;

    public HelloController(SomeService service) {
        this.service = service;
    }

    @GetMapping("/greeting")
    public String hello(){
        return service.greet();
    }

    @GetMapping("")
    public String second(){
        return "something was returned...";
    }

    @GetMapping("/msg")
    public String giveMessage(){
        return new MessageService().greet();
    }
}
