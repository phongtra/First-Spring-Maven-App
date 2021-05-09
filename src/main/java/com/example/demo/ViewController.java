package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    private List<Person> list;
    private String message;

    public ViewController() {
        this.list = new ArrayList<Person>();
        this.list.add(new Person());
        this.list.add(new Person("Phong Tran"));
        this.list.add(new Person("Thao Nguyen"));
    }

    @PostMapping("/")
    public String post(@RequestParam String name) {
        System.out.println(name);
        this.message = name;
        return "redirect:/hello";
    }

    @GetMapping("/hello")
    public String home(Model model) {
        model.addAttribute("text", "Hello");
        model.addAttribute("persons", this.list);

        model.addAttribute("message", this.message);

        return "index";
    }
}
