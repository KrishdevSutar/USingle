package com.usingle.chat;


public interface ChatMessage {

    enum Type {
        IMAGE,
        TEXT
    }

    boolean isFromMe();
    Type getType();
}
