package com.pingpals.PingPals.controllers;

import com.pingpals.PingPals.repository.GroupChatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GroupChatController {
    private final GroupChatRepository groupChatRepository;

    public GroupChatController(GroupChatRepository groupChatRepository) {
        this.groupChatRepository = groupChatRepository;
    }

    @RequestMapping("/group-chats")
    public String getGroupChats(Model model){
        model.addAttribute("group-chats", groupChatRepository.findAll());
        return "chats";
    }
}
