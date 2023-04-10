package com.pingpals.PingPals.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;        // primary key
    private LocalDate createdAt;

    // Participation Table
    @ManyToMany
    @JoinTable(name = "Participation", joinColumns = @JoinColumn(name = "chatId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users = new HashSet<>();

    // Message Table
    @OneToMany(mappedBy = "chatId")
    private Set<Message> messages = new HashSet<>();

    // Group Table
    @OneToOne(mappedBy = "chatId", optional = true)
    private GroupChat groupId;


    public Chat() {}
    public Chat(Long id, LocalDate createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


    public Set<Message> getMessages() {
        return messages;
    }
    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }


    public GroupChat getGroup() {
        return groupId;
    }
    public void setGroup(GroupChat groupId) {
        this.groupId = groupId;
    }


    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", users=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chat chat = (Chat) o;

        return Objects.equals(id, chat.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
