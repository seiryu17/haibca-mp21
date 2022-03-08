package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// display list of employees
    @GetMapping("/user")
    public String viewUserPage(Model model) {
    	model.addAttribute("listUsers", userService.getAllUsers());
        model.addAttribute("title","User Page");
        return "user/index";
    }
    
    @GetMapping("/new-user")
    public String newUser(Model model) {
    	User user = new User();
    	model.addAttribute("user", user);
    	return "user/new-user";
    }
    
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("User") User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword =  passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    	userService.saveUser(user);
    	return "redirect:/user";
    }
    
    @GetMapping("/edit-user/{id}")
    public String editUser(@PathVariable(value = "id") long id, Model model) {

        // get user from the service
        User user = userService.getUserById(id);

        // set user as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "user/update-user";
    }
    
    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.userService.deleteUserById(id);
        return "redirect:/user";
    }
}
