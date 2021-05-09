package com.example.demo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MultipleController {
    @GetMapping("/route")
    @ResponseBody
    public String route(@RequestParam String route) {
        return "this is route " + route;
    }

    @GetMapping("/path")
    @ResponseBody
    public String path(@RequestParam String name, @RequestParam int age) {
        return "this is path " + name + " and age of " + age;
    }

    @GetMapping("/multiple-params")
    @ResponseBody
    public String multiple(@RequestParam Map<String, String> params) {
        return params.keySet().toString() + params.values().toString();
    }
}
