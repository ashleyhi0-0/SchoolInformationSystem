package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FeePage {
    JFrame frame = new JFrame();

    // Labels for fee breakdown
    JLabel tuitionLabel = new JLabel("Tuition Fee:");
    JLabel miscLabel = new JLabel("Miscellaneous Fee:");
    JLabel otherFeesLabel = new JLabel("Other Fees:");
    JLabel totalLabel = new JLabel("Total Fee:");

    // Values for fees
    JLabel tuitionValue = new JLabel();
    JLabel miscValue = new JLabel();
    JLabel otherFeesValue = new JLabel();
    JLabel totalValue = new JLabel();
    JLabel gradeLabel = new JLabel("Grade Level: ");
    JButton continueButton = new JButton("Continue");

    FeePage(String gradeLevel) { // Receive grade level from StudentForm
        // Calculate fees based on grade level
        double tuitionFee = calculateTuition(gradeLevel);
        double miscFee = calculateMisc(gradeLevel);
        double otherFees = calculateOtherFees(gradeLevel);

        double totalFee = tuitionFee + miscFee + otherFees;

        gradeLabel.setText("Grade Level: " + gradeLevel);  // Display the selected grade level

        // Set label values
        tuitionValue.setText("₱ " + tuitionFee);
        miscValue.setText("₱ " + miscFee);
        otherFeesValue.setText("₱ " + otherFees);
        totalValue.setText("₱ " + totalFee);

        // Frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // Main panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Display the selected grade level
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(gradeLabel, gbc);

        // Tuition Fee
        gbc.gridy = 1;
        panel.add(tuitionLabel, gbc);
        gbc.gridx = 1;
        panel.add(tuitionValue, gbc);

        // Miscellaneous Fee
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(miscLabel, gbc);
        gbc.gridx = 1;
        panel.add(miscValue, gbc);

        // Other Fees
        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(otherFeesLabel, gbc);
        gbc.gridx = 1;
        panel.add(otherFeesValue, gbc);

        // Total Fee
        gbc.gridy = 4;
        gbc.gridx = 0;
        panel.add(totalLabel, gbc);
        gbc.gridx = 1;
        panel.add(totalValue, gbc);

        // Continue Button
        gbc.gridy = 5;
        gbc.gridx = 0;
        continueButton.setPreferredSize(new Dimension(150, 30));
        continueButton.addActionListener(e -> {
            frame.dispose();
            // Continue to the next page (e.g., PaymentMethod page)
            new PaymentMethod(gradeLevel); // Example call, assuming PaymentMethod exists
        });
        panel.add(continueButton, gbc);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    private double calculateTuition(String gradeLevel) {
        // Sample tuition fees by grade level
        switch (gradeLevel) {
            case "1": return 15000;
            case "2": return 16000;
            case "3": return 20000;
            case "4": return 20000;
            case "5": return 22000;
            case "6": return 22000;
            default: return 0;
        }
    }

    private double calculateMisc(String gradeLevel) {
        // Sample miscellaneous fees by grade level
        switch (gradeLevel) {
            case "1": return 1600;
            case "2": return 1800;
            case "3": return 2300;
            case "4": return 2500;
            case "5": return 3100;
            case "6": return 3400;
            default: return 0;
        }
    }

    private double calculateOtherFees(String gradeLevel) {
        return 950;
    }
}
