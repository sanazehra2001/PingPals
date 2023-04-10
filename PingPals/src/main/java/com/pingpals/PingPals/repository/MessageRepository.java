package com.pingpals.PingPals.repository;

import com.pingpals.PingPals.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository <Message, Long> {
}
