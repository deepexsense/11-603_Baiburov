package ru.kpfu.utils;

import org.springframework.stereotype.Service;

@Service
public class SimpleCalculator implements Calculator {
    @Override
    public String calculate(Long a, Long b, String operation) {
        switch (operation){
            case "+":
                return a + b + "";
            case "-":
                return a - b + "";
            case "/":
                return a / b + "";
            case "*":
                return a * b + "";
            default:
                return "I don't know what to do";
        }
    }
}
