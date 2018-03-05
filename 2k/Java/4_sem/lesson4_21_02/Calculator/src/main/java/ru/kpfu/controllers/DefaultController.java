package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.utils.SimpleCalculator;

@Controller
public class DefaultController {
    private SimpleCalculator calculator;

    @Autowired
    public DefaultController(SimpleCalculator simpleCalculator) {
        this.calculator = simpleCalculator;
    }

    @RequestMapping(value = "/hardcode", method = RequestMethod.GET)
    @ResponseBody
    public String getHardcode(){
        return "Hardcode String";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    @ResponseBody
    public String calculate(@RequestParam("a") Long a, @RequestParam("b") Long b, @RequestParam("op") String operation){
        return calculator.calculate(a, b, operation);
    }
}
