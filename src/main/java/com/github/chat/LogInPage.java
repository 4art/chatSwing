package com.github.chat.ui;

import com.github.chat.MainGUI;
import com.github.chat.model.User;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPage extends JFrame{

  private JLabel username;
  private JButton loginbutton;
  private JPanel panelMain, panelForm;
  private Font font; 
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
    mainGUI.setUsernameChooser(new JTextField(15));
    

    username = new JLabel("Username:");
    loginbutton = new JButton("Login");
    panelMain = new JPanel();
    getContentPane().add(panelMain);    
    panelForm = new JPanel(new GridBagLayout());
    panelMain.add(panelForm);
    GridBagConstraints c = new GridBagConstraints();

    c.gridx = 1;
    c.gridy = 0;
    
    font = new Font("Arial", Font.PLAIN, 18);
 
    username.setFont(font);
    panelForm.add(username, c);
    
    c.gridy++;
    
    panelForm.add(mainGUI.getUsernameChooser(), c);
    
 
    mainGUI.getPreFrame().add(BorderLayout.CENTER, panelForm);
    mainGUI.getPreFrame().add(BorderLayout.SOUTH, loginbutton);
    mainGUI.getPreFrame().setVisible(true);
    mainGUI.getPreFrame().setSize(400, 400);
    

    loginbutton.addActionListener(new LogInPageEvent());
  }



  class LogInPageEvent implements ActionListener {     //KLasse
    public void actionPerformed(ActionEvent event) {
      User user = new User();
      user.setUsername(mainGUI.getUsernameChooser().getText());
      mainGUI.setUser(user);
      if (mainGUI.getUser().getUsername().length() < 1) {
        JOptionPane.showMessageDialog(null, "Username must be at least 1 character long");
      } else {
        mainGUI.getPreFrame().setVisible(false);
        final Chat chat = new Chat();
        chat.setMainGUI(mainGUI);
        chat.display();
        
        
        
      }
    }

  }
  
}
