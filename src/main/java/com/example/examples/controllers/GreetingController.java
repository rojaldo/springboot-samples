package com.example.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {
    
    @GetMapping("/greeting")
    public String greeting(
        @RequestParam(name="name", required=false, defaultValue="World") String name, 
        Model view) {
        view.addAttribute("message", name);
        return "greeting";
    }


    @GetMapping("/greeting/{name}/info")
    public String greetingPath(
        @PathVariable String name, 
        Model view) {
        view.addAttribute("message", name);
        return "greeting";
    }
   
}
