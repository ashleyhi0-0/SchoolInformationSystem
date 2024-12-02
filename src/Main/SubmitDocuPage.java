package Main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class SubmitDocuPage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel displayLabel = new JLabel("Documents Submission");

    JLabel psa = new JLabel("HAVE YOU SUBMITTED THE PSA: ");
    JButton buttonSubmitPSA = new JButton("Submitted");
    JButton notSubmitPSA = new JButton("Not Yet");

    JLabel goodMoral = new JLabel("HAVE YOU SUBMITTED THE GOOD MORAL: ");
    JButton bGoodMoral = new JButton("Submitted");
    JButton notSubmitGM = new JButton("Not Yet");

    JLabel form137 = new JLabel("HAVE YOU SUBMITTED THE FORM 138: ");
    JButton Bform137 = new JButton("Submitted");
    JButton notSubmit173 = new JButton("Not Yet");

    JButton backButton = new JButton("Back");
    JLabel messageLabel = new JLabel();

    JButton submitButton = new JButton("Continue");

    String enrollmentType;
    String gradeLevel;
    
    SubmitDocuPage(String enrollmentType, String gradeLevel) {
        this.enrollmentType = enrollmentType;
        this.gradeLevel = gradeLevel;
        messageLabel.setText("Enrollment Type: " + enrollmentType + " | Grade Level: " + gradeLevel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);

        // Main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(200, 220, 255));
        GridBagConstraints set = new GridBagConstraints();
        set.insets = new Insets(10, 10, 10, 10);
        set.gridx = 0;
        set.gridy = 0;
        set.anchor = GridBagConstraints.CENTER;

        // Title
        displayLabel.setFont(new Font("Arial", Font.BOLD, 20));
        set.gridwidth = 2;
        mainPanel.add(displayLabel, set);

        // PSA Section
        set.gridx = 1;
        set.gridy = 1;
        set.gridwidth = 1;
        mainPanel.add(psa, set);

        set.gridx = 2;
        set.gridy = 1;
        buttonSubmitPSA.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(buttonSubmitPSA, set);
        buttonSubmitPSA.setFocusable(false);
        buttonSubmitPSA.addActionListener(this);

        set.gridx = 3;
        set.gridy = 1;
        notSubmitPSA.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(notSubmitPSA, set);
        notSubmitPSA.setFocusable(false);
        notSubmitPSA.addActionListener(this);

        // Good Moral Section
        set.gridx = 1;
        set.gridy = 2;
        set.gridwidth = 1;
        mainPanel.add(goodMoral, set);

        set.gridx = 2;
        set.gridy = 2;
        bGoodMoral.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(bGoodMoral, set);
        bGoodMoral.setFocusable(false);
        bGoodMoral.addActionListener(this);

        set.gridx = 3;
        set.gridy = 2;
        notSubmitGM.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(notSubmitGM, set);
        notSubmitGM.setFocusable(false);
        notSubmitGM.addActionListener(this);

        // Form 137 Section
        set.gridx = 1;
        set.gridy = 3;
        mainPanel.add(form137, set);

        set.gridx = 2;
        set.gridy = 3;
        Bform137.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(Bform137, set);
        Bform137.setFocusable(false);
        Bform137.addActionListener(this);

        set.gridx = 3;
        set.gridy = 3;
        notSubmit173.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(notSubmit173, set);
        notSubmit173.setFocusable(false);
        notSubmit173.addActionListener(this);

        // Back Button
        set.gridx = 2;
        set.gridy = 11;
        backButton.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(backButton, set);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

         //Buttons
        set.gridx = 3;
        set.gridy = 11;
        submitButton.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(submitButton, set);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        // Message Label
        set.gridx = 2;
        set.gridy = 4;
        set.gridwidth = 3;
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(messageLabel, set);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSubmitPSA) {
            messageLabel.setText("PSA Submitted");
        } else if (e.getSource() == notSubmitPSA) {
            messageLabel.setText("PSA Not Submitted");
        } else if (e.getSource() == bGoodMoral) {
            messageLabel.setText("Good Moral Submitted");
        } else if (e.getSource() == notSubmitGM) {
            messageLabel.setText("Good Moral Not Submitted");
        } else if (e.getSource() == Bform137) {
            messageLabel.setText("Form 138 Submitted");
        } else if (e.getSource() == notSubmit173) {
            messageLabel.setText("Form 138 Not Submitted");
        } else if (e.getSource() == backButton) {
            frame.dispose();
            new WelcomePage();
        }else if(e.getSource() == submitButton){
            frame.dispose();
            new FeePage(gradeLevel);
        }
    }
}
class TransfereeSubmitDocuPage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel transferee = new JLabel("Transferee Enrollment");

    // Labels
    JLabel firstNameLabel = new JLabel("First Name:");
    JTextField firstNameField = new JTextField();
    JLabel lastNameLabel = new JLabel("Last Name:");
    JTextField lastNameField = new JTextField();
    JLabel middleNameLabel = new JLabel("Middle Name:");
    JTextField middleNameField = new JTextField();
    JLabel schoolId = new JLabel("School ID:");
    JTextField schoJTextField = new JTextField();

    String[] gradeLevel = {"1", "2", "3", "4", "5", "6"};
    JLabel lastGradeLabel = new JLabel("Completed Grade Level: ");
    JComboBox<String> lastGradeBox = new JComboBox<>(gradeLevel);

    JLabel previousSchool = new JLabel("Last School went to:");
    JTextField previousSchoolField = new JTextField();

    JButton cButton = new JButton("Continue");
    JButton backButton = new JButton("Back");

    TransfereeSubmitDocuPage() {
        JPanel mainTransJPanel = new JPanel(new GridBagLayout());
        mainTransJPanel.setBackground(new Color(200, 220, 255));
        GridBagConstraints set = new GridBagConstraints();
        set.insets = new Insets(10, 10, 10, 10);
        set.anchor = GridBagConstraints.WEST;  // Align components to the left (WEST)

        // Title Label
        set.gridx = 0; 
        set.gridy = 0; 
        set.gridwidth = 3; // Span across multiple columns
        set.anchor = GridBagConstraints.CENTER;
        transferee.setFont(new Font("Arial", Font.BOLD, 16));
        mainTransJPanel.add(transferee, set);
        
        // Name Labels and Fields
        set.gridwidth = 1; // Reset to default gridwidth for following components
        set.gridx = 0; 
        set.gridy = 1;
        mainTransJPanel.add(firstNameLabel, set);
        set.gridx = 1;
        mainTransJPanel.add(lastNameLabel, set);
        set.gridx = 2;
        mainTransJPanel.add(middleNameLabel, set);

        // Name Fields
        set.gridx = 0;
        set.gridy = 2;
        firstNameField.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(firstNameField, set);
        set.gridx = 1;
        lastNameField.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(lastNameField, set);
        set.gridx = 2;
        middleNameField.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(middleNameField, set);

        // School ID
        set.gridx = 0; 
        set.gridy = 3; 
        mainTransJPanel.add(schoolId, set);
        set.gridx = 1;
        schoJTextField.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(schoJTextField, set);

        // Last Grade Level
        set.gridx = 0; 
        set.gridy = 5; 
        mainTransJPanel.add(lastGradeLabel, set);
        set.gridx = 1;
        mainTransJPanel.add(lastGradeBox, set);

                // Previous School
                set.gridx = 0; 
                set.gridy = 7; 
                mainTransJPanel.add(previousSchool, set);
                set.gridx = 1;
                previousSchoolField.setPreferredSize(new Dimension(150, 30));
                mainTransJPanel.add(previousSchoolField, set);

        //continue
        set.gridx = 2;
        set.gridy = 8;
        cButton.addActionListener(this);
        cButton.setFocusable(false);
        cButton.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(cButton, set);
        
        //back
        set.gridx = 1;
        set.gridy = 8;
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(backButton, set);
        

        // Final Setup
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(new JScrollPane(mainTransJPanel));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    @Override   
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == backButton) {
            frame.dispose();
            new WelcomePage();
        }else if (e.getSource() == cButton) {
            String enrollmentType = "Transferee";  // You might want to get these dynamically based on the input
            String gradeLevel = (String) lastGradeBox.getSelectedItem();
            frame.dispose();
            new SubmitDocuPage(enrollmentType, gradeLevel);  // Pass the required parameters
        }
    }
}

class ReturneeSubmitDocuPage implements ActionListener{
    JFrame frame = new JFrame();
    JLabel transferee = new JLabel("Returnee Enrollment");

    // Labels
    JLabel firstNameLabel = new JLabel("First Name:");
    JTextField firstNameField = new JTextField();
    JLabel lastNameLabel = new JLabel("Last Name:");
    JTextField lastNameField = new JTextField();
    JLabel middleNameLabel = new JLabel("Middle Name:");
    JTextField middleNameField = new JTextField();
    JLabel schoolId = new JLabel("School ID:");
    JTextField schoJTextField = new JTextField();

    String[] gradeLevel = {"1", "2", "3", "4", "5", "6"};
    JLabel lastGradeLabel = new JLabel("Last Grade Level: ");
    JComboBox<String> lastGradeBox = new JComboBox<>(gradeLevel);

    JLabel schoolYearCompleted = new JLabel("School Year Completed: ");
    JTextField schoolYearField = new JTextField();

    JButton cButton = new JButton("Continue");
    JButton backButton = new JButton("Back");

    ReturneeSubmitDocuPage() {
        JPanel mainTransJPanel = new JPanel(new GridBagLayout());
        mainTransJPanel.setBackground(new Color(200, 220, 255));
        GridBagConstraints set = new GridBagConstraints();
        set.insets = new Insets(10, 10, 10, 10);
        set.anchor = GridBagConstraints.WEST;  // Align components to the left (WEST)

        // Title Label
        set.gridx = 0; 
        set.gridy = 0; 
        set.gridwidth = 3; // Span across multiple columns
        set.anchor = GridBagConstraints.CENTER;
        transferee.setFont(new Font("Arial", Font.BOLD, 16));
        mainTransJPanel.add(transferee, set);
        
        // Name Labels and Fields
        set.gridwidth = 1; // Reset to default gridwidth for following components
        set.gridx = 0; 
        set.gridy = 1;
        mainTransJPanel.add(firstNameLabel, set);
        set.gridx = 1;
        mainTransJPanel.add(lastNameLabel, set);
        set.gridx = 2;
        mainTransJPanel.add(middleNameLabel, set);

        // Name Fields
        set.gridx = 0;
        set.gridy = 2;
        firstNameField.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(firstNameField, set);
        set.gridx = 1;
        lastNameField.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(lastNameField, set);
        set.gridx = 2;
        middleNameField.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(middleNameField, set);

        // School ID
        set.gridx = 0; 
        set.gridy = 3; 
        mainTransJPanel.add(schoolId, set);
        set.gridx = 1;
        schoJTextField.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(schoJTextField, set);

        // Last Grade Level
        set.gridx = 0; 
        set.gridy = 5; 
        mainTransJPanel.add(lastGradeLabel, set);
        set.gridx = 1;
        mainTransJPanel.add(lastGradeBox, set);

        //schoolyear completed
        set.gridx = 0;
        set.gridy = 6;
        mainTransJPanel.add(schoolYearCompleted, set);
        set.gridx = 1;
        schoolYearField.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(schoolYearField, set);

        //continue
        set.gridx = 2;
        set.gridy = 7;
        cButton.setPreferredSize(new Dimension(150, 30));
        cButton.addActionListener(this);
        cButton.setFocusable(false);
        mainTransJPanel.add(cButton, set);

        //back
        set.gridx = 1;
        set.gridy = 7;
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setPreferredSize(new Dimension(150, 30));
        mainTransJPanel.add(backButton, set);

        // Final Setup
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(new JScrollPane(mainTransJPanel));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            frame.dispose();
            new WelcomePage();
        }else if (e.getSource() == cButton) {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String middleName = middleNameField.getText().trim();
            String enrollmentType = "Returnee";  // You might want to get these dynamically based on the input
            String gradeLevel = (String) lastGradeBox.getSelectedItem();
            frame.dispose();

            InnerStudentInfo othersInfo = new InnerStudentInfo(lastName, firstName, middleName);

            saveOthersInfoToFile(othersInfo);
            
            new SubmitDocuPage(enrollmentType, gradeLevel);  // Pass the required parameters
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    private void saveOthersInfoToFile(InnerStudentInfo othInfo){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("ReturneeAndTransferee.txt", true))){
            writer.write("Basic information of Returnee and Transferee\n");
            writer.write("Name: " + othInfo.getFirstName() + " " + othInfo.getMiddleName() + " " + othInfo.getLastName()+"\n");
            writer.write("--------------------------------\n");
            
        }catch (IOException e) {
            System.out.println("An error occurred while saving student data.");
            e.printStackTrace();
        }
    }
}

