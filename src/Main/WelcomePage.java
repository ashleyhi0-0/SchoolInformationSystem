package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WelcomePage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Enrolling As");

    JButton newStudentB = new JButton("New Student");
    JButton transfereeB = new JButton("Transferee");
    JButton returneeB = new JButton("Returnee");

    WelcomePage() {
        // Frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Makes the frame fullscreen
        frame.setResizable(false); // Disables resizing
        frame.setLocationRelativeTo(null); // Centers the frame on the screen

        // Main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(200, 220, 255));
        GridBagConstraints set = new GridBagConstraints();
        set.insets = new Insets(20, 20, 20, 20); // Spacing between components
        set.anchor = GridBagConstraints.CENTER;

        // Title
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Bigger font for better visibility
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        set.gridx = 0;
        set.gridy = 0;
        set.gridwidth = 1;
        mainPanel.add(welcomeLabel, set);

        // New Student Button
        set.gridy = 1;
        newStudentB.setPreferredSize(new Dimension(200, 60)); // Bigger buttons
        newStudentB.setFont(new Font("Arial", Font.PLAIN, 20));
        newStudentB.setFocusable(false);
        newStudentB.addActionListener(this);
        mainPanel.add(newStudentB, set);

        // Transferee Button
        set.gridy++;
        transfereeB.setPreferredSize(new Dimension(200, 60));
        transfereeB.setFont(new Font("Arial", Font.PLAIN, 20));
        transfereeB.setFocusable(false);
        transfereeB.addActionListener(this);
        mainPanel.add(transfereeB, set);

        // Returnee Button
        set.gridy++;
        returneeB.setPreferredSize(new Dimension(200, 60));
        returneeB.setFont(new Font("Arial", Font.PLAIN, 20));
        returneeB.setFocusable(false);
        returneeB.addActionListener(this);
        mainPanel.add(returneeB, set);

        // Center the panel in the frame
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newStudentB) {
            frame.dispose();
            new StudentForm("New Student"); // Replace with your class
        } else if (e.getSource() == transfereeB) {
            frame.dispose();
            new TransfereeSubmitDocuPage(); // Replace with your class
        } else if (e.getSource() == returneeB) {
            frame.dispose();
            new ReturneeSubmitDocuPage(); // Replace with your class
        }
    }
}
