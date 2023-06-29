package com.example.chatbot;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Chat {
@PrimaryKey (autoGenerate = true)
    private int id;
    private String chat;
    private String message;

    private String message_date;

    private String image;

    public Chat(int id, String chat, String message) {
        this.id = id;
        this.chat = chat;
        this.message = message;
        this.message_date = message_date;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getChat() {
        return chat;
    }

    public String getImage() {return image;}

    public String getMessage() {
        return message;
    }

    public String getMessage_date() {return message_date;}

    public void setId(int id) {
        this.id = id;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public void setImage(String image) {this.image = image;}

    public void setMessage_date(String message_date) {this.message_date = message_date;}
}
