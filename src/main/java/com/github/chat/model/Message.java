package com.github.chat.model;

import java.time.LocalDateTime;

public class Message {

    private User user;          //KLasse User und user Variablenname
    private String message;
    private LocalDateTime localtime;


    public Message() {

    }

    public Message(User user, String message, LocalDateTime localtime) {
        this.user = user;
        this.message = message;
        this.localtime = localtime;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocaltime() {
        return localtime;
    }

    public void setLocaltime(LocalDateTime localtime) {
        this.localtime = localtime;
    }
}
