package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.models.Student;
import ru.kpfu.utils.StudentServiceImpl;

@Controller
public class DefaultController {
    private StudentServiceImpl studentService;

    @Autowired
    public DefaultController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@RequestParam(name = "id", required = false) Long id){
        Student student = studentService.getById(id);
        if(student != null) {
            return student.toString();
        }
        else {
            return "Not found";
        }
    }

    @RequestMapping(value = "/hardcode", method = RequestMethod.GET)
    @ResponseBody
    public String getHardcode(){
        return "Hardcode String";
    }
}
