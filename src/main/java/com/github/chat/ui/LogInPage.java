package com.github.chat.ui;

import com.github.chat.MainGUI;
import com.github.chat.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPage extends MainGUI {

    private JLabel chooseUsernameLabel;
    private JButton enterServer;
    private JPanel panelMain, panelForm;
    private Font font;

    public void preDisplay() {
        getNewFrame().setVisible(false);
        setPreFrame(new JFrame("Choose your username!(Safe Chat (Gruppe B)"));
        setUsernameChooser(new JTextField(15));

        chooseUsernameLabel = new JLabel("Username:");
        enterServer = new JButton("Enter Chat Server");
        panelMain = new JPanel();
        panelForm = new JPanel(new GridBagLayout());
        panelMain.add(panelForm);
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 1;
        c.gridy = 0;

        font = new Font("Arial", Font.PLAIN, 18);

        chooseUsernameLabel.setFont(font);
        panelForm.add(chooseUsernameLabel, c);
        c.gridy++;
        panelForm.add(getUsernameChooser(), c);

        getPreFrame().add(BorderLayout.CENTER, panelForm);
        getPreFrame().add(BorderLayout.SOUTH, enterServer);
        getPreFrame().setVisible(true);
        getPreFrame().setSize(400, 400);

        enterServer.addActionListener(new LogInPageEvent());
    }

    class LogInPageEvent implements ActionListener {     //KLasse
        public void actionPerformed(ActionEvent event) {
            User user = new User();
            user.setUsername(getUsernameChooser().getText());
            setUser(user);
            if (getUser().getUsername().length() < 1) {
                JOptionPane.showMessageDialog(null, "Username must be at least 1 character long");
            } else {
                getPreFrame().setVisible(false);
                final Chat chat = new Chat(user);
                chat.display();
            }
        }

    }
}
