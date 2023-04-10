package com.pingpals.PingPals.bootstrap;

import com.pingpals.PingPals.model.Chat;
import com.pingpals.PingPals.model.User;
import com.pingpals.PingPals.repository.ChatRepository;
import com.pingpals.PingPals.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;

    public BootStrapData(UserRepository userRepository, ChatRepository chatRepository) {
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDate createdAt = LocalDate.of(2022, 4, 5);
        LocalDateTime lastLogin = LocalDateTime.of(2022, 4, 5, 15,30);

        User eric = new User(1001001L, "Eric123", "eric", "eric@gmail.com", createdAt, lastLogin);
        Chat chat = new Chat(192937L, createdAt);

        eric.getChats().add(chat);
        chat.getUsers().add(eric);

        userRepository.save(eric);
        chatRepository.save(chat);
    }
}
