package com.pingpals.PingPals.bootstrap;

import com.pingpals.PingPals.model.Chat;
import com.pingpals.PingPals.model.User;
import com.pingpals.PingPals.repository.ChatRepository;
import com.pingpals.PingPals.repository.GroupChatRepository;
import com.pingpals.PingPals.repository.MessageRepository;
import com.pingpals.PingPals.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class BootStrapData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final GroupChatRepository groupChatRepository;

    public BootStrapData(UserRepository userRepository, ChatRepository chatRepository, MessageRepository messageRepository, GroupChatRepository groupChatRepository) {
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
        this.groupChatRepository = groupChatRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        LocalDate createdAt = LocalDate.of(2022, 4, 5);
        LocalDateTime lastLogin = LocalDateTime.of(2022, 4, 5, 15,30);

        User eric = new User(1001001L, "Eric123", "eric", "eric@gmail.com", createdAt, lastLogin);
        Chat chat = new Chat(192937L, createdAt);

        userRepository.save(eric);
        chatRepository.save(chat);

        eric.getChats().add(chat);
        System.out.println(eric.toString());

        System.out.println("Started in bootstrap");
        System.out.println("User count: " + userRepository.count());
        System.out.println("Chat count: " + chatRepository.count());
    }
}
