package com.example.servingwebcontent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping
    public String goToStartApplicationPage() {
        return "index";
    }
}
