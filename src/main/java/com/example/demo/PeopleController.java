package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PeopleController {
    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping("/people")
    public String peopleList(Model model) {
        model.addAttribute("peopleList", peopleRepository.findAll());
        return "people";
    }

    @PostMapping("/people")
    public String addPeople(@RequestParam String name) {
        peopleRepository.save(new People(name));
        return "redirect:/people";
    }

    @GetMapping("/people/{id}")
    public String getOne(Model model, @PathVariable Long id) {
        model.addAttribute("selected", peopleRepository.getOne(id));
        return "person";
    }
}
