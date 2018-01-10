
package login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Fenster extends JFrame{

    public Fenster(){
        super("Login");
        setLayout(null);
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        //Label erstellt mit anderer Schriftart
        JLabel Titel = new JLabel("User Login");
        Titel.setBounds(132,-20,300,100);
        Font schriftart = new Font("Tahoma", Font.BOLD, 24);
        Titel.setFont(schriftart);
        add(Titel);
        
        //TextField für Username
        JTextField Username = new JTextField("Username");
        Username.setBounds(100, 80, 200, 35);
        add(Username);
        
        //PasswordFiel für Password
        JPasswordField Password = new JPasswordField("Password");
        Password.setBounds(100, 125, 200, 35);
        add(Password);
        
        //Buttons für Login
        JButton Login = new JButton("Login");
        Login.setBounds(165, 170, 70, 35);
        add(Login);
        
        //Button für Registrierung
        JButton Register = new JButton ("Create an account");
        Register.setBounds(125, 213, 150, 35);
        Register.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        Register.setBorderPainted(false);
        Register.setContentAreaFilled(false);
        Register.setForeground(Color.blue);
        Font hyperlink = new Font("Arial", Font.ITALIC, 14);
        Register.setFont(hyperlink);
        add(Register);
        
        //ActionListener für Register (= Create an account -Button)
        Register.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                Registration registration = new Registration();
            }
        }); 
        
        

        
    
    
    
    }       
                 
}
