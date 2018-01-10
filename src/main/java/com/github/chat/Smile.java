
package emojis;
import java.awt.event.*;
import javax.swing.*;

public class Smile extends Abstract{
        public void setLabel(JFrame y, JLabel x) {
        JLabel jl = new JLabel(new ImageIcon("src/emojis/Smile.png"));
        jl.setBounds(20, 10, 50, 50);
        y.add(jl);
        
            jl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
           
                //In Chatbox einfügen
                
            }
            });
        
    }
}
