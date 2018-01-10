
package login;
import java.awt.event.*;
import javax.swing.*;

public class Registration extends JFrame{
    
    public Registration() {
        super("Registration Form");
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(30,50,50,50);
        add(name);
        
        JLabel password = new JLabel("Password:");
        password.setBounds(30,80,70,70);
        add(password);
        
        JLabel address = new JLabel("Address:");
        address.setBounds(30,110,90,90);
        add(address);
        
        JButton register = new JButton("Register");
        register.setBounds(100, 200, 100, 30);
        add(register);
        
        JTextField name_f = new JTextField();
        name_f.setBounds(116, 60, 150, 25);
        add(name_f);
        
        JPasswordField password_f = new JPasswordField();
        password_f.setBounds(116, 102, 150, 25);
        add(password_f);     
        
        JTextField address_f = new JTextField();
        address_f.setBounds(116, 144, 150, 25);
        add(address_f);
        
        //Password Validation
        password_f.addActionListener(new ActionListener() {
            
            int Cap_counter = 0,
                Num_counter = 0,
                Spe_counter = 0;
            
            public void actionPerformed(ActionEvent e) {
                String string;
                string = String.format("%s", e.getActionCommand());
                
                for(int i = 0; i<string.length(); i++){
                    if(string.charAt(i) >= 65 && string.charAt(i) <= 90)
                        Cap_counter++;
                    else if(string.charAt(i) >= 48 && string.charAt(i) <= 57)
                        Num_counter++;
                    else if(string.charAt(i) >= 33 && string.charAt(i) <= 47 || string.charAt(i) >= 58 && string.charAt(i) <= 64 || string.charAt(i) >= 91 && string.charAt(i) <= 96)
                        Spe_counter++;    
                }
                if(string.length() < 8)
                    JOptionPane.showMessageDialog(null, "Need at least 8 character");
                else if(Cap_counter < 1)
                    JOptionPane.showMessageDialog(null, "Need at least 1 Capital letter");
                else if(Num_counter < 1)
                    JOptionPane.showMessageDialog(null, "Need at least 1 number");
                else if(Spe_counter < 1)
                    JOptionPane.showMessageDialog(null, "Need at least 1 special character");
                
                
            }
        });        
        
        
        
    }
}
