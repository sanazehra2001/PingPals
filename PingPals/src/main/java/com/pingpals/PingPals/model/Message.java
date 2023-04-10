package com.pingpals.PingPals.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;        // primary key

    @ManyToOne
    private Chat chat;

    @ManyToOne
    private User sender;

    private String content;
    private LocalDateTime sentAt;
    private LocalDateTime deliveredAt;
    private LocalDateTime seenAt;

    public Message() {
    }

    public Message(Long id, Chat chat, User sender, String content, LocalDateTime sentAt, LocalDateTime deliveredAt, LocalDateTime seenAt) {
        this.id = id;
        this.chat = chat;
        this.sender = sender;
        this.content = content;
        this.sentAt = sentAt;
        this.deliveredAt = deliveredAt;
        this.seenAt = seenAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public LocalDateTime getSeenAt() {
        return seenAt;
    }

    public void setSeenAt(LocalDateTime seenAt) {
        this.seenAt = seenAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", chat=" + chat +
                ", sender=" + sender +
                ", content='" + content + '\'' +
                ", sentAt=" + sentAt +
                ", deliveredAt=" + deliveredAt +
                ", seenAt=" + seenAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}