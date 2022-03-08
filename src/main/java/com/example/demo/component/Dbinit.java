package com.example.demo.component;

import javax.annotation.PostConstruct;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Dbinit {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void postConstruct() {
        User checkUser = userRepository.findByEmail("admin");
        if(checkUser == null){
            User admin = new User();
            admin.setFullName("admin");
            admin.setEmail("admin");
            admin.setUserName("admin");
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword =  passwordEncoder.encode("admin");
            admin.setPassword(encodedPassword);
            userRepository.save(admin);
        }
        
    }
}
