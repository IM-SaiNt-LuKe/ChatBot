package com.example.chatbot;

import java.util.ArrayList;
import java.util.List;

public class MemoryDatabase {

    private static List<Chat> chatList;

    private static List<Chat> initializeList() {
        if (chatList == null) {
            chatList = new ArrayList<>();
        }
        return chatList;
    }

    public static List<Chat> getAllChats() {
        return initializeList();
    }

    public static Chat getChatForPosition(int position) {
        return initializeList().get(position);
    }
}
