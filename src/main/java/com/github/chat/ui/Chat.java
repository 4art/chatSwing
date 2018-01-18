package com.github.chat.ui;

import com.github.chat.MainGUI;
import com.github.chat.model.Message;
import com.github.chat.service.MessageMonitoring;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Chat{
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

    mainGUI.setMessageBox(new JTextField(32));
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
    mainGUI.getNewFrame().setSize(650, 600);
    //creating object for message monitoring
    messageMonitoring = new MessageMonitoring(mainGUI.getChatBox());
    //start monitoring and loading all messages from DB
    messageMonitoring.start();
    
    JButton color = new JButton("color");
    southPanel.add(color, right);
    
    
    JButton emo = new JButton(new ImageIcon("src/main/resources/static/Smiling_Face_Emoji_large.png"));
    southPanel.add(emo, right);
    emo.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){

            mainGUI.setPreFrame(new JFrame("Emojis"));
            mainGUI.getPreFrame().setVisible(true);
            mainGUI.getPreFrame().setSize(300, 80);
           
            JPanel panelForm = new JPanel();
            panelForm.setLayout(new FlowLayout(FlowLayout.LEFT));
            
            mainGUI.getPreFrame().add(panelForm);
            
            JLabel smileLabel = new JLabel(new ImageIcon("src/main/resources/static/Smile.png"));
            JLabel laughLabel = new JLabel(new ImageIcon("src/main/resources/static/laugh.png"));
            JLabel cryLabel = new JLabel(new ImageIcon("src/main/resources/static/cry.png"));
            JLabel sadLabel = new JLabel(new ImageIcon("src/main/resources/static/sad.png"));
            JLabel heartLabel = new JLabel(new ImageIcon("src/main/resources/static/heart.png"));

            
            panelForm.add(smileLabel);
            panelForm.add(laughLabel);
            panelForm.add(cryLabel);
            panelForm.add(sadLabel);
            panelForm.add(heartLabel);
            
            
            smileLabel.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    mainGUI.getMessageBox().setText(mainGUI.getMessageBox().getText() + ":-)");
                    
                }
            });
            laughLabel.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    mainGUI.getMessageBox().setText(mainGUI.getMessageBox().getText() + ":-D");
                    
                }
            });
            cryLabel.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    mainGUI.getMessageBox().setText(mainGUI.getMessageBox().getText() + ":'(");
                    
                }
            });
            sadLabel.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    mainGUI.getMessageBox().setText(mainGUI.getMessageBox().getText() + ":-(");
                    
                }
            });
            heartLabel.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    mainGUI.getMessageBox().setText(mainGUI.getMessageBox().getText() + "<3");
                    
                }
            });
        

        
        
        }
    });
    
          
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
        messageMonitoring.getBackendImpl().setMessage(message);
        //clear message box(input)
        mainGUI.getMessageBox().setText("");
      }
    }
  }
}
