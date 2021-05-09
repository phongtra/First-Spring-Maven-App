package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HospitalController {
    @GetMapping("/hospital")
    @ResponseBody
    public String Home() {
        return "this is hospital route";
    }
}