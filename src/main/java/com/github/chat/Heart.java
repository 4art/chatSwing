
package emojis;
import java.awt.event.*;
import javax.swing.*;

public class Heart extends Abstract{
    
        public void setLabel(JFrame y, JLabel x) {
        JLabel jl5 = new JLabel(new ImageIcon("src/emojis/Heart.png"));
        jl5.setBounds(260, 10, 50, 50);
        y.add(jl5);
        
            jl5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            
                //In Chatbox einfügen
                
            }
            });
        
    }
}
