package com.cristianperez.revolutionstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.SecurityProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private InMemoryUserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {


        String registeredUser = username.trim();

        var userToRegister = org.springframework.security.core.userdetails.User.builder()
                .username(registeredUser)
                .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();


        userDetailsManager.createUser(userToRegister);
        System.out.println("User created: " + registeredUser);
        System.out.println("Password created: " + password);


        return "redirect:/login";
    }
}