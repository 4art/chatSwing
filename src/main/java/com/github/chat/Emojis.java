
package emojis;
import java.awt.event.*;
import javax.swing.*;

public class Emojis {


    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(null);
        jf.setSize(450,300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        
        JLabel smile = null;
        JLabel laugh = null;
        JLabel cry   = null;
        JLabel sad   = null;
        JLabel heart = null;
        
        JButton emo = new JButton("Emojis");
        emo.setBounds(170, 100, 100, 40);
        jf.add(emo);
        
        emo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
        
            JFrame jf2 = new JFrame();
            jf2.setSize(350, 105);
            jf2.setLocationRelativeTo(null);
            jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf2.setVisible(true);
            jf2.setLayout(null);
                
            Smile test = new Smile();
            test.setLabel(jf2, smile);
        
            Laugh test2 = new Laugh();
            test2.setLabel(jf2, laugh);
        
            Cry test3 = new Cry();
            test3.setLabel(jf2, cry);
        
            Sad test4 = new Sad();
            test4.setLabel(jf2, sad);
        
            Heart test5 = new Heart();
            test5.setLabel(jf2, heart);
            
            }
        });
    }
    
}
