package com.tablas.relacionales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppControllerAll {
    @GetMapping("")
    public String inicio_web(){
        return "index";
    }
}
