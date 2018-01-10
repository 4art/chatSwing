
package emojis;
import java.awt.event.*;
import javax.swing.*;

public class Laugh extends Abstract{
    
        public void setLabel(JFrame y, JLabel x) {
        JLabel jl2 = new JLabel(new ImageIcon("src/emojis/Laugh.png"));
        jl2.setBounds(80, 10, 50, 50);
        y.add(jl2);
        
            jl2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            
                //In Chatbox einfügen
                
            }
            });
        
    }
}
