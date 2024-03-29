package com.pingpals.PingPals.controllers;

import com.pingpals.PingPals.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping
    public String getUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }
}
