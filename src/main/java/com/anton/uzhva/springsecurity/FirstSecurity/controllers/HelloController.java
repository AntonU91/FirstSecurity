package com.anton.uzhva.springsecurity.FirstSecurity.controllers;

import com.anton.uzhva.springsecurity.FirstSecurity.model.Person;
import com.anton.uzhva.springsecurity.FirstSecurity.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person person = personDetails.getPerson();
        System.out.println(person);
        model.addAttribute("person", person);
        return "showUserInfo";
    }
}
