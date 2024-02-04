package ru.gb.homework7_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/login")
    public String signIn() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost() {
        return "public";
    }

    @GetMapping("/private-data")
    public String privateData() {
        return "private";
    }

    @GetMapping("/public-data")
    public String publicData() {
        return "public";
    }
}
