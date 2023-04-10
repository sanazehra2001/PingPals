package com.pingpals.PingPals.controllers;

import com.pingpals.PingPals.repository.ChatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
    private final ChatRepository chatRepository;

    public ChatController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @RequestMapping("/chats/{id}")

    public String getChatsById(Model model, @PathVariable("id") long id){
        model.addAttribute("chats", chatRepository.findById(id));
        return "chats";
    }

}
