package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class NewStudentPage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel newStudentLabel = new JLabel("Complete the Student Information");

    JLabel firstNameLabel = new JLabel("First Name:");
    JTextField firstNameField = new JTextField();

    JLabel lastNameLabel = new JLabel("Last Name:");
    JTextField lastNameField = new JTextField();

    JLabel middleNameLabel = new JLabel("Middle Name:");
    JTextField middleNameField = new JTextField();

    JLabel ageLabel = new JLabel("Age:");
    JTextField ageField = new JTextField();

    JLabel genderLabel = new JLabel("Gender:");
    JTextField genderField = new JTextField();

    JLabel phoneNumberLabel = new JLabel("Phone Number:");
    JTextField phoneNumField = new JTextField();

    JLabel addressLabel = new JLabel("Address: ");
    JTextField addressField = new JTextField();

    JLabel birthDateLabel = new JLabel("Birth Date: ");
    JTextField birthDateField = new JTextField();

    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("Back");

    JLabel messageLabel = new JLabel();

    NewStudentPage() {
        newStudentLabel.setBounds(80, 10, 300, 35);
        newStudentLabel.setFont(new Font(null, Font.PLAIN, 15));

        firstNameLabel.setBounds(10, 50, 100, 25);
        firstNameField.setBounds(120, 50, 200, 25);

        lastNameLabel.setBounds(10,85, 100, 25);
        lastNameField.setBounds(120, 85, 200, 25);

        middleNameLabel.setBounds(10, 120, 100, 25);
        middleNameField.setBounds(120, 120, 200, 25);

        ageLabel.setBounds(10, 155, 100, 25);
        ageField.setBounds(120, 155, 200, 25);

        genderLabel.setBounds(10, 190, 100, 25);
        genderField.setBounds(120, 190, 200, 25);

        phoneNumberLabel.setBounds(10, 225, 100, 25);
        phoneNumField.setBounds(120, 225, 200, 25);

        addressLabel.setBounds(10, 260, 100, 25);
        addressField.setBounds(120, 260, 200, 25);

        birthDateLabel.setBounds(10, 295, 100, 25);
        birthDateField.setBounds(120, 295, 200, 25);
        // Submit button
        submitButton.setBounds(120, 330, 85, 30);
        submitButton.addActionListener(this);
        // Back buttonn
        backButton.setBounds(235, 330, 85, 30);
        backButton.addActionListener(this);

        frame.add(newStudentLabel);
        frame.add(firstNameLabel);
        frame.add(firstNameField);
        frame.add(lastNameLabel);
        frame.add(lastNameField);
        frame.add(middleNameLabel);
        frame.add(middleNameField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(genderLabel);
        frame.add(submitButton);
        frame.add(genderField);
        frame.add(phoneNumberLabel);
        frame.add(phoneNumField);
        frame.add(addressLabel);
        frame.add(addressField);
        frame.add(birthDateLabel);
        frame.add(birthDateField);
        frame.add(backButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==submitButton){
            String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String middleName = middleNameField.getText().trim();
        String gender = genderField.getText().trim();
        String phoneNumber = phoneNumField.getText().trim();
        String address = addressField.getText().trim();
        String birthDate = birthDateField.getText().trim();
        
        int age = 0;
        try {
            age = Integer.parseInt(ageField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number for age.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
                StudentDetails studentInfo = new StudentDetails(lastName, firstName, middleName, age, gender, phoneNumber, address, birthDate);

        saveStudentToFile(studentInfo);
                // Display confirmation message
                JOptionPane.showMessageDialog(frame,
                "Student Information Saved:\n" +
                        "First Name: " + studentInfo.getFirstName() + "\n" +
                        "Last Name: " + studentInfo.getLastName() + "\n" +
                        "Middle Name: " + studentInfo.getMiddleName() + "\n" +
                        "Age: " + studentInfo.getAge(),
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == backButton){
            frame.dispose();
            new WelcomePage();
        }
    }

    private void saveStudentToFile(StudentDetails student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true))) {
            writer.write("Name: " + student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName() + "\n");
            writer.write("Age: " + student.getAge() + "\n");
            writer.write("Address: " + student.getAddress() + "\n");
            writer.write("Gender: " + student.getGender() + "\n");
            writer.write("Birth Date: " + student.getBirthDate() + "\n");
            writer.write("Phone Number: " + student.getPhoneNumber() + "\n");
            writer.write("--------------------------------\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving student data.");
            e.printStackTrace();
        }
    }
}
