package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// display list of employees
    @GetMapping("/user")
    public String viewUserPage(Model model) {
    	model.addAttribute("listUsers", userService.getAllUsers());
        return "user/index";
    }
}
