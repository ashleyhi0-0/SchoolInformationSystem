package Main;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class TransfereePage {
    JFrame frame = new JFrame();
    JLabel transferee = new JLabel("Transferee");

    TransfereePage(){
        transferee.setBounds(100, 0, 300, 35);
        transferee.setFont(new Font(null, Font.PLAIN,15));

        frame.add(transferee);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
