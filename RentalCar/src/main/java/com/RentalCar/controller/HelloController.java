package com.RentalCar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "HELLO MARIA!";
    }

    @GetMapping(value = "/helloMaria")
    public String hello2(){
        return "HELLO MARIA PACE!";
    }
}
