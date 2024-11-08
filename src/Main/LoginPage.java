package Main;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
public class LoginPage implements ActionListener{

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    
    JLabel userIdLabel = new JLabel("UserID: ");
    JTextField userIdField = new JTextField();
    
    JLabel userPasswordLabel = new JLabel("Password: ");
    JPasswordField userPasswordField = new JPasswordField();

    JLabel messageLabel = new JLabel();

    HashMap<String, String> logininfo = new HashMap<String, String>();
    LoginPage(HashMap<String, String>loginInfoOriginal){
        logininfo = loginInfoOriginal;

        userIdLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIdField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 75, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(250, 200, 75, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetButton){
            userIdField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource()==loginButton){
            String userId = userIdField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userId)){
                if(logininfo.get(userId).equals(userPassword)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successful");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage();
                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password");
                }
            }
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("UserID Not found");
            }
        }
    }
}
