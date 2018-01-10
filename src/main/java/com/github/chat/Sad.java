
package emojis;
import java.awt.event.*;
import javax.swing.*;


public class Sad extends Abstract{
    
        public void setLabel(JFrame y, JLabel x) {
        JLabel jl4 = new JLabel(new ImageIcon("src/emojis/Sad.png"));
        jl4.setBounds(200, 10, 50, 50);
        y.add(jl4);
        
            jl4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            
                //In Chatbox einfügen
                
            }
            });
        
        
    }
}
