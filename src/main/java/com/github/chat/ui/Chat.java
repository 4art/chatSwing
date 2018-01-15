package com.github.chat.ui;

import com.github.chat.MainGUI;
import com.github.chat.model.Message;
import com.github.chat.service.MessageMonitoring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Chat {
  private MainGUI mainGUI;

  public MainGUI getMainGUI() {
    return mainGUI;
  }

  public void setMainGUI(MainGUI mainGUI) {
    this.mainGUI = mainGUI;
  }

  private MessageMonitoring messageMonitoring;

  public void display() {           //Instanzmethode
    mainGUI.getNewFrame().setVisible(true);
    JPanel southPanel = new JPanel();
    mainGUI.getNewFrame().add(BorderLayout.SOUTH, southPanel);
    southPanel.setBackground(Color.WHITE);
    southPanel.setLayout(new GridBagLayout());

    mainGUI.setMessageBox(new JTextField(38));
    mainGUI.setSendMessage(new JButton("Send Message"));
    mainGUI.setChatBox(new JTextArea());
    mainGUI.getChatBox().setEditable(false);
    mainGUI.getNewFrame().add(new JScrollPane(mainGUI.getChatBox()), BorderLayout.CENTER);

    mainGUI.getChatBox().setLineWrap(true);

    GridBagConstraints left = new GridBagConstraints();
    left.anchor = GridBagConstraints.WEST;
    GridBagConstraints right = new GridBagConstraints();
    right.anchor = GridBagConstraints.EAST;
    right.weightx = 2.0;

    southPanel.add(mainGUI.getMessageBox(), left);
    southPanel.add(mainGUI.getSendMessage(), right);

    mainGUI.getChatBox().setFont(new Font("Serif", Font.PLAIN, 15));
    mainGUI.getSendMessage().addActionListener(new sendMessageButtonListener());
    mainGUI.getNewFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainGUI.getNewFrame().setSize(600, 600);
    //creating object for message monitoring
    messageMonitoring = new MessageMonitoring(mainGUI.getChatBox());
    //start monitoring and loading all messages from DB
    messageMonitoring.start();
  }

  class sendMessageButtonListener implements ActionListener {     //Klasse
    public void actionPerformed(ActionEvent event) {
      if (mainGUI.getMessageBox().getText().length() < 1) {
        // do nothing
      } else if (mainGUI.getMessageBox().getText().equals(".clear")) {
        mainGUI.getChatBox().setText("Cleared all messages\n");
        mainGUI.getMessageBox().setText("");
      } else {
        Message message = new Message();
        message.setMessage(mainGUI.getMessageBox().getText());
        message.setLocaltime(LocalDateTime.now(ZoneId.of("Europe/Paris")));
        message.setUser(mainGUI.getUser());
        //saving message to DB
        messageMonitoring.getBackend().setMessage(message);
        //clear message box(input)
        mainGUI.getMessageBox().setText("");
      }
    }
  }
}
