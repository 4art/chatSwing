package com.github.chat.ui;

import com.github.chat.MainGUI;
import com.github.chat.model.Message;
import com.github.chat.model.User;
import com.github.chat.service.MessageMonitoring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Chat extends MainGUI {

    private MessageMonitoring messageMonitoring;

    public Chat(User user){
        this.setUser(user);
    }

    public void display() {           //Instanzmethode
        getNewFrame().setVisible(true);
        JPanel southPanel = new JPanel();
        getNewFrame().add(BorderLayout.SOUTH, southPanel);
        southPanel.setBackground(Color.WHITE);
        southPanel.setLayout(new GridBagLayout());

        setMessageBox(new JTextField(32));
        setSendMessage(new JButton("Send Message"));
        setChatBox(new JTextArea());
        getChatBox().setEditable(false);
        getNewFrame().add(new JScrollPane(getChatBox()), BorderLayout.CENTER);

        getChatBox().setLineWrap(true);

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.WEST;
        GridBagConstraints right = new GridBagConstraints();
        right.anchor = GridBagConstraints.EAST;
        right.weightx = 2.0;


        southPanel.add(getMessageBox(), left);
        southPanel.add(getSendMessage(), right);

        getChatBox().setFont(new Font("Serif", Font.PLAIN, 15));
        getSendMessage().addActionListener(new sendMessageButtonListener());
        getNewFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getNewFrame().setSize(650, 600);
        //creating object for message monitoring
        messageMonitoring = new MessageMonitoring(getChatBox());
        //start monitoring and loading all messages from DB
        messageMonitoring.start();

        JButton color = new JButton("color");
        southPanel.add(color, right);


        JButton emo = new JButton(new ImageIcon("src/main/resources/static/Smiling_Face_Emoji_large.png"));
        southPanel.add(emo, right);
        emo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                setPreFrame(new JFrame("Emojis"));
                getPreFrame().setVisible(true);
                getPreFrame().setSize(300, 80);

                JPanel panelForm = new JPanel();
                panelForm.setLayout(new FlowLayout(FlowLayout.LEFT));

                getPreFrame().add(panelForm);

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


                smileLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        getMessageBox().setText(getMessageBox().getText() + ":-)");

                    }
                });
                laughLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        getMessageBox().setText(getMessageBox().getText() + ":-D");

                    }
                });
                cryLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        getMessageBox().setText(getMessageBox().getText() + ":'(");

                    }
                });
                sadLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        getMessageBox().setText(getMessageBox().getText() + ":-(");

                    }
                });
                heartLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        getMessageBox().setText(getMessageBox().getText() + "<3");

                    }
                });


            }
        });


    }

    class sendMessageButtonListener implements ActionListener {     //Klasse
        public void actionPerformed(ActionEvent event) {
            if (getMessageBox().getText().length() < 1) {
                // do nothing
            } else if (getMessageBox().getText().equals(".clear")) {
                getChatBox().setText("Cleared all messages\n");
                getMessageBox().setText("");
            } else {
                Message message = new Message();
                message.setMessage(getMessageBox().getText());
                message.setLocaltime(LocalDateTime.now(ZoneId.of("Europe/Paris")));
                message.setUser(getUser());
                //saving message to DB
                messageMonitoring.getBackendImpl().setMessage(message);
                //clear message box(input)
                getMessageBox().setText("");
            }
        }
    }
}
