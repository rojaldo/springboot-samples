package com.example.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String calculator(
        @RequestParam(name="num1", required=true) int a, 
        @RequestParam(name="num2", required=true) int b, 
        @RequestParam(name="op", required=true) String op, 
        Model view) {
        double result = 0;
        // cast to double to avoid integer division
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = (double)a / b;
                break;
            default:
                break;
        }
        view.addAttribute("num1", a);
        view.addAttribute("num2", b);
        view.addAttribute("op", op);
        view.addAttribute("result", result);

        return "calculator";
    }

    @GetMapping("/calculator/{operation}")
    public String calculatorPath(
        @PathVariable String operation, 
        Model view) {

        return "calculator";
    }


}
