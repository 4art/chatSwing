package com.github.chat;

import com.github.chat.model.Message;
import com.github.chat.model.User;
import com.github.chat.ui.LogInPage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainGUI {
  private MainGUI mainGUI;
  private JFrame newFrame = new JFrame("Safe Chat (Gruppe B)");
  private JButton sendMessage;
  private JTextField messageBox;
  private JTextArea chatBox;
  private JTextField usernameChooser;
  private JFrame preFrame;
  private User user;
  private List<Message> messageList;

  public MainGUI() {
    messageList = new ArrayList<Message>();
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public MainGUI getMainGUI() {
    return mainGUI;
  }

  public void setMainGUI(MainGUI mainGUI) {
    this.mainGUI = mainGUI;
  }

  public JFrame getNewFrame() {
    return newFrame;
  }

  public void setNewFrame(JFrame newFrame) {
    this.newFrame = newFrame;
  }

  public JButton getSendMessage() {
    return sendMessage;
  }

  public void setSendMessage(JButton sendMessage) {
    this.sendMessage = sendMessage;
  }

  public JTextField getMessageBox() {
    return messageBox;
  }

  public void setMessageBox(JTextField messageBox) {
    this.messageBox = messageBox;
  }

  public JTextArea getChatBox() {
    return chatBox;
  }

  public void setChatBox(JTextArea chatBox) {
    this.chatBox = chatBox;
  }

  public JTextField getUsernameChooser() {
    return usernameChooser;
  }

  public void setUsernameChooser(JTextField usernameChooser) {
    this.usernameChooser = usernameChooser;
  }

  public JFrame getPreFrame() {
    return preFrame;
  }

  public void setPreFrame(JFrame preFrame) {
    this.preFrame = preFrame;
  }

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    MainGUI mainGUI = new MainGUI();
    LogInPage logInPage = new LogInPage();
    logInPage.setMainGUI(mainGUI);
    logInPage.preDisplay();
  }

  public void appendMessageList(Message message) {
    messageList.add(message);
  }

}
