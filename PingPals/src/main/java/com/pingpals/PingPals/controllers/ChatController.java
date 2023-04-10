package com.pingpals.PingPals.controllers;

import com.pingpals.PingPals.repository.ChatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
    private final ChatRepository chatRepository;

    public ChatController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @RequestMapping("/chats")
    public String getChats(Model model){
        model.addAttribute("chats", chatRepository.findAll());
        return "books";
    }

}
