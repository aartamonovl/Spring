package ru.gb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/M1")
public class AppController {

    @GetMapping("/hello")
    public String hello(){
        return "Micro1";
    }
}
