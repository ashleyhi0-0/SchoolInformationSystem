package Main;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class StudentForm implements ActionListener {
    private String enrollmentType;

    JFrame frame = new JFrame();
    String[] sex = {"Male", "Female"};
    String[] schoolYear = {"2025 - 2026","2026 - 2027"};
    String[] gradeLevel = {"1","2","3","4","5","6"};
    JComboBox gradeBox = new JComboBox<>(gradeLevel);
    JComboBox comboBox = new JComboBox<>(sex);
    JComboBox schoolBox = new JComboBox<>(schoolYear);

    JLabel newStudentLabel = new JLabel("Complete the Student Information");
    JLabel guardianNameLabel = new JLabel("Guardian First Name:");
    JTextField guardianNameField = new JTextField();

    JLabel guardianLastNameLabel = new JLabel("GuardianLast Name:");
    JTextField guardianLastNameField = new JTextField();

    JLabel guardianMiddleNameLabel = new JLabel("Guardian Middle Name:");
    JTextField guardianMiddleNameField = new JTextField();

    JLabel firstNameLabel = new JLabel("First Name:");
    JTextField firstNameField = new JTextField();

    JLabel lastNameLabel = new JLabel("Last Name:");
    JTextField lastNameField = new JTextField();

    JLabel middleNameLabel = new JLabel("Middle Name:");
    JTextField middleNameField = new JTextField();

    JLabel ageLabel = new JLabel("Age:");
    JTextField ageField = new JTextField();

    JLabel sexLabel = new JLabel("Sex:");

    JLabel phoneNumberLabel = new JLabel("Parents Contact No. :");
    JTextField phoneNumField = new JTextField();

    JLabel emaiLabel = new JLabel("Parents Email:");
    JTextField emaiField = new JTextField();

    JLabel addressLabel = new JLabel("Address: ");
    JTextField addressField = new JTextField();

    JLabel birthDateLabel = new JLabel("Birth Date(MM, DD, YY): ");
    JDateChooser birthDate = new JDateChooser();

    JLabel schoolyearEnrolling = new JLabel("School Year Enrolling:");
    JLabel gradeLevLabel = new JLabel("Grade Level:");

    JButton submitButton = new JButton("Continue");
    JButton backButton = new JButton("Back");

    JLabel messageLabel = new JLabel("Hello");

    StudentForm(String enrollmentType) {
        this.enrollmentType = enrollmentType;
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(200, 220, 255));
        GridBagConstraints set = new GridBagConstraints();
        set.insets = new Insets(10, 10, 10, 10);
        set.anchor = GridBagConstraints.CENTER;
        set.fill = GridBagConstraints.HORIZONTAL;

        firstNameField.setToolTipText("Enter your first name");
        lastNameField.setToolTipText("Enter your last name");
        middleNameField.setToolTipText("Enter your middle name");
        addressField.setToolTipText("Enter your address");
        ageField.setToolTipText("Enter your age");
        phoneNumField.setToolTipText("Enter your phone number");

        //NameLabel
        set.gridx = 1; 
        set.gridy =1;
        mainPanel.add(firstNameLabel, set);
        set.gridx = 2;
        set.gridy =1;
        mainPanel.add(lastNameLabel, set);
        set.gridx = 3;
        set.gridy =1;
        mainPanel.add(middleNameLabel, set);

        //NameField
        set.gridx = 1;
        set.gridy = 2;
        firstNameField.setPreferredSize(new Dimension(300, 30));
        mainPanel.add(firstNameField, set);
        set.gridx = 2;
        set.gridy = 2;
        lastNameField.setPreferredSize(new Dimension(300, 30));
        mainPanel.add(lastNameField, set);
        set.gridx = 3;
        set.gridy = 2;
        middleNameField.setPreferredSize(new Dimension(300, 30));
        mainPanel.add(middleNameField, set);

                //GuardianNameLabel
                set.gridx = 1;
                set.gridy = 3;
                mainPanel.add(guardianNameLabel, set);
                set.gridx = 2;
                set.gridy = 3;
                mainPanel.add(guardianLastNameLabel, set);
                set.gridx = 3;
                set.gridy = 3;
                mainPanel.add(guardianMiddleNameLabel, set);
        
                //GuardianNameField
                set.gridx = 1;
                set.gridy = 4;
                guardianNameField.setPreferredSize(new Dimension(300, 30));
                mainPanel.add(guardianNameField, set);
                set.gridx = 2;
                set.gridy = 4;
                guardianLastNameField.setPreferredSize(new Dimension(300, 30));
                mainPanel.add(guardianLastNameField, set);
                set.gridx = 3;
                set.gridy = 4;
                guardianMiddleNameField.setPreferredSize(new Dimension(300,30));
                mainPanel.add(guardianMiddleNameField, set);        

        //Age
        set.gridx = 1;
        set.gridy = 5;
        mainPanel.add(ageLabel, set);
        set.gridx = 2;
        set.gridy=5;
        ageField.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(ageField,set);

        //Sex
        set.gridx = 1;
        set.gridy = 6;
        mainPanel.add(sexLabel, set);
        set.gridx = 2;
        set.gridy = 6;
        mainPanel.add(comboBox, set);

        //PhoneNumber
        set.gridx = 1;
        set.gridy = 7;
        mainPanel.add(phoneNumberLabel, set);
        set.gridx = 2;
        set.gridy = 7;
        phoneNumField.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(phoneNumField, set);

        //Email
        set.gridx = 1;
        set.gridy = 8;
        mainPanel.add(emaiLabel, set);
        set.gridx = 2;
        set.gridy = 8;
        emaiField.setPreferredSize(new Dimension(150,30));
        mainPanel.add(emaiField, set);

        //Address
        set.gridx = 1;
        set.gridy = 9;
        mainPanel.add(addressLabel, set);
        set.gridx = 2;
        set.gridy = 9;
        addressField.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(addressField, set);

        // Birth Date
        set.gridx = 1;
        set.gridy = 10;
        mainPanel.add(birthDateLabel, set);
        set.gridx = 2;
        set.gridy = 10;
        birthDate.setPreferredSize(new Dimension(150, 30));
        mainPanel.add(birthDate, set);  

        //SchoolYear
        set.gridx = 1;
        set.gridy = 11;
        mainPanel.add(schoolyearEnrolling, set);
        set.gridx = 2;
        set.gridy = 11;
        mainPanel.add(schoolBox,set);

        //GradeLevel
        set.gridx = 1;
        set.gridy = 12;
        mainPanel.add(gradeLevLabel, set);
        set.gridx = 2;
        set.gridy = 12;
        mainPanel.add(gradeBox, set);


        //Buttons
        set.gridx = 3;
        set.gridy = 13;
        mainPanel.add(submitButton, set);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        set.gridx = 2;
        set.gridy = 13;
        mainPanel.add(backButton, set);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        //NewStudentLabel
        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.gridx = 1; 
        labelConstraints.gridy = 0; 
        labelConstraints.gridwidth = 3; 
        labelConstraints.anchor = GridBagConstraints.CENTER;
        labelConstraints.insets = new Insets(20, 10, 10, 10); // Optional: Adjust top padding
        newStudentLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.add(newStudentLabel);
        mainPanel.add(labelPanel, labelConstraints);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        frame.add(scrollPane);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submitButton) {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String middleName = middleNameField.getText().trim();
        String phoneNumber = phoneNumField.getText().trim();
        String address = addressField.getText().trim();
        String sex = (String) comboBox.getSelectedItem();
        String email = emaiField.getText().trim();
        String schoolYear = (String) schoolBox.getSelectedItem();
        String gradeLevel = (String) gradeBox.getSelectedItem();
        // Convert Date to String (format it)
        java.util.Date selectedDate = birthDate.getDate();
        String formattedBirthDate = "";
        if (selectedDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            formattedBirthDate = sdf.format(selectedDate);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a valid birth date.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int age = 0;
        try {
            age = Integer.parseInt(ageField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number for age.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Now pass the formatted birth date to the StudentDetails constructor
        StudentDetails studentInfo = new StudentDetails(lastName, firstName, middleName, age, sex, phoneNumber, address, formattedBirthDate, email, schoolYear, gradeLevel);

        // Save student to file
        saveStudentToFile(studentInfo);

        // Display confirmation message
        JOptionPane.showMessageDialog(frame,
            "Student Information Saved:\n" +
            "Name: " + studentInfo.getFirstName() + " " + studentInfo.getLastName() + " " + studentInfo.getMiddleName() + "\n" +
            "Age: " + studentInfo.getAge(),
            "Success",
            JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
            new FeePage(gradeLevel);
            
    } else if (e.getSource() == backButton) {
        frame.dispose();
        new WelcomePage();
    } 
}


    private void saveStudentToFile(StudentDetails student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true))) {
            writer.write("Name: " + student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName() + "\n");
            writer.write("Age: " + student.getAge() + "\n");
            writer.write("Address: " + student.getAddress() + "\n");
            writer.write("Sex: " + student.getSex() + "\n");
            writer.write("Birth Date: " + student.getBirthDate() + "\n");
            writer.write("Parents Phone Number: " + student.getPhoneNumber() + "\n");
            writer.write("Parents Email: " + student.getEmail() + "\n");
            writer.write("School Year: " + student.getSchoolYear()+"\n");
            writer.write("Grade Level: " + student.getGradeLevel()+"\n");
            writer.write("--------------------------------\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving student data.");
            e.printStackTrace();
        }
    }
}
