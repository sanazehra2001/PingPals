package com.pingpals.PingPals.repository;

import com.pingpals.PingPals.model.Chat;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<Chat, Long> {
}
