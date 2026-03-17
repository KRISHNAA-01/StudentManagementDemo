package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloService implements SomeService{
    @Value("${app.message}")
    private String msg;

    public String greet(){
        return " <div style='display:flex; align-items:center; justify-content:center; height:100vh;'>"+
                    "<h1>"+msg+"</h1>"+
                "</div>"
                ;
    }
}
