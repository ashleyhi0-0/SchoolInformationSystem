package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage implements ActionListener{
 JFrame frame = new JFrame();
 JLabel welcomeLabel = new JLabel("Enrolling As");

 JButton newStudentB = new JButton("New Student");
 JButton transfereeB = new JButton("Transferee");
 JButton returneeB = new JButton("Returnee");

 WelcomePage(){
    welcomeLabel.setBounds(125, 0, 200, 35);
    welcomeLabel.setFont(new Font(null, Font.PLAIN,25));

    newStudentB.setBounds(100, 50, 200, 25);
    newStudentB.setFocusable(false);
    newStudentB.addActionListener(this);

    transfereeB.setBounds(100, 100, 200, 25);
    transfereeB.setFocusable(false);
    transfereeB.addActionListener(this);

    returneeB.setBounds(100, 150, 200, 25);
    returneeB.setFocusable(false);
    returneeB.addActionListener(this);

    frame.add(newStudentB);
    frame.add(transfereeB);
    frame.add(returneeB);
    frame.add(welcomeLabel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 420);
    frame.setLayout(null);
    frame.setVisible(true);
 }

@Override
public void actionPerformed(ActionEvent e) {

    if (e.getSource() == newStudentB) {
        frame.dispose(); 
        NewStudentPage studentPage = new NewStudentPage(); 
    } else if (e.getSource() == transfereeB) {
        frame.dispose(); 
        TransfereePage transfereePage = new TransfereePage();
    } else if (e.getSource() == returneeB) {
        frame.dispose(); 
        ReturneePage returneePage = new ReturneePage(); 
    }
    }
}
