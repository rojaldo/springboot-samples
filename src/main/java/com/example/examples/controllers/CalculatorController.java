package com.example.examples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.examples.services.CalculatorService;



@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator(
            @RequestParam(name = "num1", required = true) int a,
            @RequestParam(name = "num2", required = true) int b,
            @RequestParam(name = "op", required = true) String op,
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
                result = (double) a / b;
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
                this.calculatorService.processOperation(operation);
        if (this.calculatorService.isValidExpression()) {
            view.addAttribute("num1", this.calculatorService.getFirstFigure());
            view.addAttribute("num2", this.calculatorService.getSecondFigure());
            view.addAttribute("op", this.calculatorService.getOperator());
            view.addAttribute("result", this.calculatorService.getResult());

        }else {
            view.addAttribute("num1", "");
            view.addAttribute("num2", "");
            view.addAttribute("op", operation);
            view.addAttribute("result", ": Invalid operation");
        }
        this.calculatorService.initStateMachine();
        return "calculator";
    }




}
