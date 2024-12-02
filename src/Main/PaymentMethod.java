package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class PaymentMethod implements ActionListener {

    JFrame frame = new JFrame();
    JLabel discountLabel = new JLabel("Do you have a discount?");
    JButton yesButton = new JButton("Yes");
    JButton noButton = new JButton("No");

    JPanel discountPanel = new JPanel();
    double totalFee;
    DecimalFormat df = new DecimalFormat("#,##0.00"); // For fee formatting

    PaymentMethod(String gradeLevel) {
        // Calculate the total fee based on grade level
        totalFee = calculateFees(gradeLevel);

        // Frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // Discount Panel setup
        discountPanel.setLayout(new FlowLayout());
        discountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        discountPanel.add(discountLabel);
        discountPanel.add(yesButton);
        discountPanel.add(noButton);

        // Button listeners
        yesButton.addActionListener(this);
        noButton.addActionListener(this);

        // Add panel to frame
        frame.add(discountPanel);
        frame.setVisible(true);
    }

    private double calculateFees(String gradeLevel) {
        double tuition = calculateTuition(gradeLevel);
        double misc = calculateMisc(gradeLevel);
        double other = 950; // Fixed other fees
        return tuition + misc + other;
    }

    private int calculateTuition(String gradeLevel) {
        return switch (gradeLevel) {
            case "1" -> 15000;
            case "2" -> 16000;
            case "3", "4" -> 20000;
            case "5", "6" -> 22000;
            default -> 0;
        };
    }

    private int calculateMisc(String gradeLevel) {
        return switch (gradeLevel) {
            case "1" -> 1600;
            case "2" -> 1800;
            case "3" -> 2300;
            case "4" -> 2500;
            case "5" -> 3100;
            case "6" -> 3400;
            default -> 0;
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == yesButton) {
            showDiscountOptions();
        } else if (e.getSource() == noButton) {
            proceedToPlans();
        }
    }

    private void showDiscountOptions() {
        String[] discountOptions = {"Student Achiever", "Sibling Discount"};
        String selectedOption = (String) JOptionPane.showInputDialog(frame,
                "Select Discount Type", "Discount Options",
                JOptionPane.QUESTION_MESSAGE, null, discountOptions, discountOptions[0]);

        if (selectedOption == null) return; // Handle cancel

        if (selectedOption.equals("Student Achiever")) {
            applyStudentAchieverDiscount();
        } else if (selectedOption.equals("Sibling Discount")) {
            applySiblingDiscount();
        }
    }

    private void applyStudentAchieverDiscount() {
        String[] discountAchiever = {"Honor", "High Honor", "Highest Honor"};
        String selectedAchieverDiscount = (String) JOptionPane.showInputDialog(frame,
                "Select Achievement", "Achievement Selection",
                JOptionPane.QUESTION_MESSAGE, null, discountAchiever, discountAchiever[0]);

        if (selectedAchieverDiscount == null) return; // Handle cancel

        double discount = switch (selectedAchieverDiscount) {
            case "Honor" -> 0.10;
            case "High Honor" -> 0.15;
            case "Highest Honor" -> 0.20;
            default -> 0;
        };
        totalFee *= (1 - discount);
        JOptionPane.showMessageDialog(frame, "Discount applied! Total Fee: ₱ " + df.format(totalFee));
        proceedToPlans();
    }

    private void applySiblingDiscount() {
        String[] siblingOptions = {"2 Siblings", "3 Siblings", "4 Siblings"};
        String selectedSiblingDiscount = (String) JOptionPane.showInputDialog(frame,
                "Select Number of Siblings", "Sibling Discount",
                JOptionPane.QUESTION_MESSAGE, null, siblingOptions, siblingOptions[0]);

        if (selectedSiblingDiscount == null) return; // Handle cancel

        double discount = switch (selectedSiblingDiscount) {
            case "2 Siblings" -> 0.10;
            case "3 Siblings" -> 0.20;
            case "4 Siblings" -> 0.40;
            default -> 0;
        };
        totalFee *= (1 - discount);
        JOptionPane.showMessageDialog(frame, "Discount applied! Total Fee: ₱ " + df.format(totalFee));
        proceedToPlans();
    }

    private void proceedToPlans() {
        // Create a new panel for plan selection
        JPanel planPanel = new JPanel();
        planPanel.setLayout(new GridLayout(4, 1));

        JLabel planLabel = new JLabel("Choose a Payment Plan:");
        JButton planAButton = new JButton("Plan A: Full Payment with 10% Discount");
        JButton planBButton = new JButton("Plan B: 50% Now, 50% Later");
        JButton planCButton = new JButton("Plan C: Quarterly Payment");

        // Add action listeners for plan buttons
        planAButton.addActionListener(e -> selectPlan("Plan A"));
        planBButton.addActionListener(e -> selectPlan("Plan B"));
        planCButton.addActionListener(e -> selectPlan("Plan C"));

        planPanel.add(planLabel);
        planPanel.add(planAButton);
        planPanel.add(planBButton);
        planPanel.add(planCButton);

        // Remove old panel, add new panel, revalidate and repaint
        frame.getContentPane().removeAll(); 
        frame.add(planPanel);
        frame.revalidate();
        frame.repaint();
    }

    private void selectPlan(String plan) {
        String breakdown = "";
        double planFee;

        switch (plan) {
            case "Plan A":
                planFee = totalFee * 0.90; // 10% discount for full payment
                breakdown = "Plan A: Total Fee after 10% discount: ₱ " + df.format(planFee);
                break;

            case "Plan B":
                planFee = totalFee / 2;
                breakdown = "Plan B: 50% Now: ₱ " + df.format(planFee) + ", 50% Later: ₱ " + df.format(planFee);
                break;

            case "Plan C":
                planFee = totalFee / 4;
                breakdown = "Plan C: Quarterly Payment: ₱ " + df.format(planFee) + " per quarter";
                break;
        }
        showPaymentBreakdown(plan, breakdown);
    }

    private void showPaymentBreakdown(String plan, String breakdown) {
        JPanel paymentBreakdownPanel = new JPanel();
        paymentBreakdownPanel.setLayout(new GridLayout(3, 1));

        JLabel planSelectedLabel = new JLabel("Selected Plan: " + plan);
        JTextArea breakdownArea = new JTextArea(breakdown);
        breakdownArea.setEditable(false);

        JButton proceedToPaymentButton = new JButton("Proceed to Payment");
        proceedToPaymentButton.addActionListener(e -> proceedToPayment(plan));

        JButton backButton = new JButton("Back to Plans");
        backButton.addActionListener(e -> proceedToPlans());

        paymentBreakdownPanel.add(planSelectedLabel);
        paymentBreakdownPanel.add(new JScrollPane(breakdownArea));
        paymentBreakdownPanel.add(proceedToPaymentButton);
        paymentBreakdownPanel.add(backButton);

        // Remove old panel, add new panel, revalidate and repaint
        frame.getContentPane().removeAll();
        frame.add(paymentBreakdownPanel);
        frame.revalidate();
        frame.repaint();
    }
    private void showFeeInput() {
        // Show the dialog box with the calculated fee and let the user confirm or modify it
        String feeInput = JOptionPane.showInputDialog(frame, 
                "Enter the Total Fee (₱):", 
                "Total Fee Input", 
                JOptionPane.QUESTION_MESSAGE,
                null,
                null, 
                df.format(totalFee)) // Set default to the calculated fee
                .toString();
    
        // Validate if the user has entered a valid fee
        if (feeInput != null && !feeInput.isEmpty()) {
            try {
                // Parse the fee input
                double inputFee = Double.parseDouble(feeInput.replace(",", "").replace("₱", "").trim());
                if (inputFee <= 0) {
                    throw new NumberFormatException("Fee must be greater than 0.");
                }
                totalFee = inputFee; // Update the total fee with the user input
                JOptionPane.showMessageDialog(frame, "Total Fee updated: ₱ " + df.format(totalFee));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // If no input, just proceed with the calculated fee
            JOptionPane.showMessageDialog(frame, "No changes made. Proceeding with the original fee: ₱ " + df.format(totalFee));
        }
    }

    private void proceedToPayment(String plan) {
        JOptionPane.showMessageDialog(frame, "Proceeding to payment for " + plan + ".");

        showFeeInput();
        
        String[] paymentMethods = {"Gcash", "Bank Transfer"};
        JComboBox<String> selectedPaymentMethod = new JComboBox<>(paymentMethods);
    
        JLabel myPayment = new JLabel("Account No.: ");
        JTextField payment = new JTextField();
        setTextFieldWidth(payment);
    
        JLabel LRNLabel = new JLabel("Student's LRN: ");
        JTextField lrn = new JTextField();
        setTextFieldWidth(lrn);
    
        JLabel emaiLabel = new JLabel("Email: ");
        JTextField email = new JTextField();
        setTextFieldWidth(email);
    
        JLabel referenceLabel = new JLabel("Reference No.: ");
        JTextField reference = new JTextField();
        setTextFieldWidth(reference);
    
        // Panel layout
        JPanel paymentMethodPanel = new JPanel(new GridBagLayout());
        paymentMethodPanel.setBackground(new Color(200, 220, 255));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;  // Align components to the left
        constraints.fill = GridBagConstraints.HORIZONTAL; // Make text fields stretch horizontally
        constraints.weightx = 1.0; // Allow text fields to take up available space
    
        // Adding the components to the panel using GridBagLayout
        int row = 0;
    
        // Payment method label and combo box
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.gridwidth = 2; // Make label span two columns
        paymentMethodPanel.add(new JLabel("Select Payment Method:"), constraints);
    
        constraints.gridx = 2; // Add combo box next to label
        constraints.gridwidth = 1; // Reset gridwidth
        paymentMethodPanel.add(selectedPaymentMethod, constraints);
    
        row++;
    
        // Account number label and text field
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.gridwidth = 2;
        paymentMethodPanel.add(myPayment, constraints);
    
        constraints.gridx = 2;
        paymentMethodPanel.add(payment, constraints);
    
        row++;
    
        // LRN label and text field
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.gridwidth = 2;
        paymentMethodPanel.add(LRNLabel, constraints);
    
        constraints.gridx = 2;
        paymentMethodPanel.add(lrn, constraints);
    
        row++;
    
        // Email label and text field
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.gridwidth = 2;
        paymentMethodPanel.add(emaiLabel, constraints);
    
        constraints.gridx = 2;
        paymentMethodPanel.add(email, constraints);
    
        row++;
    
        // Reference No. label and text field
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.gridwidth = 2;
        paymentMethodPanel.add(referenceLabel, constraints);
    
        constraints.gridx = 2;
        paymentMethodPanel.add(reference, constraints);
    
        row++;
    
        // Button to confirm payment
        JButton confirmPaymentButton = new JButton("Confirm Payment");
        confirmPaymentButton.addActionListener(e -> confirmPayment(plan, (String) selectedPaymentMethod.getSelectedItem()));
    
        // Adding the confirm payment button to the panel
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.gridwidth = 3; // Make the button span across columns
        paymentMethodPanel.add(confirmPaymentButton, constraints);
    
        // Add the panel to the frame and revalidate
        frame.getContentPane().removeAll();
        frame.add(paymentMethodPanel);
        frame.revalidate();
        frame.repaint();
    }
    
    // Method to set the preferred width of text fields
    private void setTextFieldWidth(JTextField textField) {
        // Set the width of the text field 
        textField.setPreferredSize(new Dimension(250, textField.getPreferredSize().height));
    }
    
    private void confirmPayment(String plan, String paymentMethod) {
        JOptionPane.showMessageDialog(frame, "Payment for " + plan + " using " + paymentMethod + " has been successfully completed.");
        showThankYouScreen();
    }

    private void showThankYouScreen() {
        JPanel thankYouPanel = new JPanel();
        thankYouPanel.setLayout(new GridBagLayout());
        thankYouPanel.setBackground(new Color(200, 255, 200));
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);  
        constraints.anchor = GridBagConstraints.CENTER;  
        
        JLabel thankYouLabel = new JLabel("Thank you for your payment!");
        thankYouLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        
        // magpapasalamat sha
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;  
        thankYouPanel.add(thankYouLabel, constraints);
        
        // create buttons and add action listeners
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> frame.dispose());
    
        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> {
            frame.dispose();  
            StudentSchedule show = new StudentSchedule();  //deretso sa student schedule window
        });
        
        //JPanel para sa buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));  // Center buttons with spacing
        buttonPanel.add(closeButton);
        buttonPanel.add(continueButton);
        
        // Constraints for button panel
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;  
        constraints.weighty = 1.0;  
 
        thankYouPanel.add(buttonPanel, constraints);
    
        frame.getContentPane().removeAll();
        frame.add(thankYouPanel);
        frame.revalidate();
        frame.repaint();
    }
    
}
