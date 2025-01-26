package com.connecttalent.connecttalentsession.helloworld.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloWorldController {


    @GetMapping("get")
    public String getHello() {
        return "Hello World! With Get Method";
    }

    @PostMapping ("post")
    public String getHelloPost() {
        return "Hello World! With Post Method";
    }

   @PutMapping("put")
    public String putHello() {
        return "Hello World! With Put Method";
    }

    @DeleteMapping("delete")
    public String deleteHello() {
        return "Hello World! With Delete Method";
    }
}
