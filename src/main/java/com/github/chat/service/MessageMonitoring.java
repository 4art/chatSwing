package com.github.chat.service;

import com.github.chat.model.Message;

import java.util.List;

public class MessageMonitoring extends Thread {
  private List<Message> messages;
  private final Backend backend = new Backend();

  private int delay = 500;

  public Backend getBackend() {
    return backend;
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

  @Override
  public void run() {
    monitoring();
  }

  private void monitoring() {
    try {
      messages = backend.getMessages();
      System.out.println("messages");
      messages.forEach(message -> System.out.println(message.getMessage()));
      Thread.sleep(delay);
      monitoring();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    MessageMonitoring messageMonitoring = new MessageMonitoring();
    messageMonitoring.start();
  }
}
