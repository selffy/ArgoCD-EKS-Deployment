package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String calculator() {
        return "index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam("num1") int num1, 
                            @RequestParam("num2") int num2, 
                            @RequestParam("operation") String operation, 
                            Model model) {
        int result = 0;
        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    model.addAttribute("error", "Division by zero is not allowed.");
                    return "index";
                }
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }
}
