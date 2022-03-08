package com.example.demo.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
            isAssignableFrom(authentication.getClass())) {
                return false;
            }
        return authentication.isAuthenticated();
    }

    // display list of employees
    @GetMapping("/login")
    public String login() {
        if(isAuthenticated()){
            return "redirect:/home";
        }else{
            return "index";
        }
    }

    // display list of employees
    @GetMapping("/home")
    public String viewHomePage(Model model) {
        model.addAttribute("title","Home");
        return "home/index";
    }

}
