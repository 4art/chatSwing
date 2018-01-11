package com.github.chat;  //Pakete, die ich brauche

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {      //Klasse
//fari
  MainGUI mainGUI;
  JFrame newFrame = new JFrame("Safe Chat (Gruppe B)");
  JButton sendMessage;
  JTextField messageBox;
  JTextArea chatBox;
  JTextField usernameChooser;
  JFrame preFrame;

  public static void main(String[] args) {      //Mainfunktion
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    MainGUI mainGUI = new MainGUI();
    mainGUI.preDisplay();
  }


  public void preDisplay() {          //Instanzmethode
    newFrame.setVisible(false);
    preFrame = new JFrame("Choose your username!(Safe Chat (Gruppe B)");
    usernameChooser = new JTextField();
    JLabel chooseUsernameLabel = new JLabel("Pick a username:");
    JButton enterServer = new JButton("Enter Chat Server");
    JPanel prePanel = new JPanel(new GridBagLayout());

    GridBagConstraints preRight = new GridBagConstraints();
    preRight.anchor = GridBagConstraints.EAST;
    GridBagConstraints preLeft = new GridBagConstraints();
    preLeft.anchor = GridBagConstraints.WEST;
    preRight.weightx = 2.0;
    preRight.fill = GridBagConstraints.HORIZONTAL;
    preRight.gridwidth = GridBagConstraints.REMAINDER;

    prePanel.add(chooseUsernameLabel, preLeft);
    prePanel.add(usernameChooser, preRight);
    preFrame.add(BorderLayout.CENTER, prePanel);
    preFrame.add(BorderLayout.SOUTH, enterServer);
    preFrame.setVisible(true);
    preFrame.setSize(400, 400);

    enterServer.addActionListener(new enterServerButtonListener());
  }

    public void display() {           //Instanzmethode
    newFrame.setVisible(true);
    JPanel southPanel = new JPanel();
    newFrame.add(BorderLayout.SOUTH, southPanel);
    southPanel.setBackground(Color.WHITE);
    southPanel.setLayout(new GridBagLayout());

    messageBox = new JTextField(38);
    sendMessage = new JButton("Send Message");
    chatBox = new JTextArea();
    chatBox.setEditable(false);
    newFrame.add(new JScrollPane(chatBox), BorderLayout.CENTER);

    chatBox.setLineWrap(true);

    GridBagConstraints left = new GridBagConstraints();
    left.anchor = GridBagConstraints.WEST;
    GridBagConstraints right = new GridBagConstraints();
    right.anchor = GridBagConstraints.EAST;
    right.weightx = 2.0;

    southPanel.add(messageBox, left);
    southPanel.add(sendMessage, right);

    chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
    sendMessage.addActionListener(new sendMessageButtonListener());
    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    newFrame.setSize(600, 600);
  }

  class sendMessageButtonListener implements ActionListener {     //Klasse
    public void actionPerformed(ActionEvent event) {
      if (messageBox.getText().length() < 1) {
        // do nothing
      } else if (messageBox.getText().equals(".clear")) {
        chatBox.setText("Cleared all messages\n");
        messageBox.setText("");
      } else {
        chatBox.append("<" + username + ">:  " + messageBox.getText() + "\n");
        messageBox.setText("");
      }
    }
  }

  String username;

  class enterServerButtonListener implements ActionListener {     //KLasse
    public void actionPerformed(ActionEvent event) {
      username = usernameChooser.getText();
      if (username.length() < 1) {
        System.out.println("No!");
      } else {
        preFrame.setVisible(false);
        display();
      }
    }

  }
}
