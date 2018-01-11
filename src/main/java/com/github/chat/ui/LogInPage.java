package com.github.chat.ui;

import com.github.chat.MainGUI;
import com.github.chat.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPage {

  private MainGUI mainGUI;

  public MainGUI getMainGUI() {
    return mainGUI;
  }

  public void setMainGUI(MainGUI mainGUI) {
    this.mainGUI = mainGUI;
  }

  public void preDisplay() {
    mainGUI.getNewFrame().setVisible(false);
    mainGUI.setPreFrame(new JFrame("Choose your username!(Safe Chat (Gruppe B)"));
    mainGUI.setUsernameChooser(new JTextField());
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
    prePanel.add(mainGUI.getUsernameChooser(), preRight);
    mainGUI.getPreFrame().add(BorderLayout.CENTER, prePanel);
    mainGUI.getPreFrame().add(BorderLayout.SOUTH, enterServer);
    mainGUI.getPreFrame().setVisible(true);
    mainGUI.getPreFrame().setSize(400, 400);

    enterServer.addActionListener(new LogInPageEvent());
  }

  class LogInPageEvent implements ActionListener {     //KLasse
    public void actionPerformed(ActionEvent event) {
      User user = new User();
      user.setUsername(mainGUI.getUsernameChooser().getText());
      mainGUI.setUser(user);
      if (mainGUI.getUser().getUsername().length() < 1) {
        System.out.println("No!");
      } else {
        mainGUI.getPreFrame().setVisible(false);
        final Chat chat = new Chat();
        chat.setMainGUI(mainGUI);
        chat.display();
      }
    }

  }
}
