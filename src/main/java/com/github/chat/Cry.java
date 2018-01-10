
package emojis;
import java.awt.event.*;
import javax.swing.*;

public class Cry extends Abstract{
    
        public void setLabel(JFrame y, JLabel x) {
        
        JLabel jl3 = new JLabel(new ImageIcon("src/emojis/Cry.png"));
        jl3.setBounds(140, 10, 50, 50);
        y.add(jl3);
            
            jl3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            
                //In Chatbox einfügen
                
            }
            });
        
    }
}
