package Main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton enrollButton = new JButton("Enroll now");

    StartPage() {
        // Setting preferred size and properties for buttons

        enrollButton.setPreferredSize(new Dimension(200, 90));
        enrollButton.setFont(new Font("Arial", Font.PLAIN, 30));
        enrollButton.setFocusable(false);
        enrollButton.addActionListener(this);

        JLabel titleLabel = new JLabel("WELCOME TO GICA ELEMENTARY SCHOOL", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(200, 220, 255));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        mainPanel.add(titleLabel, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        buttonPanel.setBackground(new Color(200, 220, 255));
        buttonPanel.add(enrollButton);

        gbc.gridy = 1; 
        mainPanel.add(buttonPanel, gbc);


        frame.add(mainPanel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setMinimumSize(new Dimension(300, 400));
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enrollButton) {
            frame.dispose();
            WelcomePage welcomePage = new WelcomePage();
        }
    }
    
    public static void main(String[] args) { new StartPage(); } }
