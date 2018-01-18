package com.github.chat;

import com.github.chat.model.Message;
import com.github.chat.model.User;
import com.github.chat.ui.Chat;
import com.github.chat.ui.LogInPage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainGUI {
  private JFrame newFrame = new JFrame("Safe Chat (Gruppe B)");
  private JButton sendMessage;
  private JTextField messageBox;
  private JTextArea chatBox;
  private JTextField usernameChooser;
  private JFrame preFrame;
  private User user;
  private List<Message> messageList;

  protected MainGUI() {
    messageList = new ArrayList<Message>();
  }

  protected User getUser() {
    return user;
  }

  protected void setUser(User user) {
    this.user = user;
  }

  protected JFrame getNewFrame() {
    return newFrame;
  }

  protected void setNewFrame(JFrame newFrame) {
    this.newFrame = newFrame;
  }

  protected JButton getSendMessage() {
    return sendMessage;
  }

  protected void setSendMessage(JButton sendMessage) {
    this.sendMessage = sendMessage;
  }

  protected JTextField getMessageBox() {
    return messageBox;
  }

  protected void setMessageBox(JTextField messageBox) {
    this.messageBox = messageBox;
  }

  protected JTextArea getChatBox() {
    return chatBox;
  }

  protected void setChatBox(JTextArea chatBox) {
    this.chatBox = chatBox;
  }

  protected JTextField getUsernameChooser() {
    return usernameChooser;
  }

  protected void setUsernameChooser(JTextField usernameChooser) {
    this.usernameChooser = usernameChooser;
  }

  protected JFrame getPreFrame() {
    return preFrame;
  }

  protected void setPreFrame(JFrame preFrame) {
    this.preFrame = preFrame;
  }

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    LogInPage logInPage = new LogInPage();
    logInPage.preDisplay();
  }

  protected void appendMessageList(Message message) {
    messageList.add(message);
  }

}
