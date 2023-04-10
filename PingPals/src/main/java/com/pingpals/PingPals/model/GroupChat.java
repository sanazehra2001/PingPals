package com.pingpals.PingPals.model;

import jakarta.persistence.*;

@Entity
public class GroupChat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToOne(optional = true)
    @JoinColumn(name = "chat", referencedColumnName = "id")
    private Chat chat;

    public GroupChat() {
    }
    public GroupChat(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public Chat getChat() {
        return chatId;
    }
    public void setChat(Chat chatId) {
        this.chatId = chatId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chat=" + chatId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupChat group)) return false;

        return id == group.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
