package com.github.chat.service;

import com.github.chat.model.Message;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//fari + erika
public class MessageMonitoring extends Thread {
    private List<Message> messages;
    private final BackendImpl backendImpl = new BackendImpl();

    private int delay = 500;

    public BackendImpl getBackendImpl() {
        return backendImpl;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public List<Message> getMessages() {
        return messages;
    }

    private JTextArea chatbox;

    //erika
    public MessageMonitoring(JTextArea chatbox) {
        super();
        this.chatbox = chatbox;
    }

    //fari
    private void setChatMessages(List<Message> chatMessages) {
        String messages = "";
        for (Message message : chatMessages) {
            messages = messages + "<" + message.getUser().getUsername() + " " + dateTimeFormatter(message.getLocaltime()) + ">:  " + message.getMessage() + "\n";
        }
        chatbox.setText(messages);
    }

    //fari
    private String dateTimeFormatter(LocalDateTime localDateTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM HH:mm");
        return localDateTime.format(formatter);
    }

    //erika
    @Override
    public void run() {
        monitoring();
    }

    //erika
    private void monitoring() {
        try {
            messages = backendImpl.getMessages();
            setChatMessages(messages);
            Thread.sleep(delay);
            monitoring();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
