package Main;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class ReturneePage {
    JFrame frame = new JFrame();
    JLabel returnee = new JLabel("Returnee");

    ReturneePage(){
        returnee.setBounds(100, 0, 300, 35);
        returnee.setFont(new Font(null, Font.PLAIN,15));

        frame.add(returnee);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
