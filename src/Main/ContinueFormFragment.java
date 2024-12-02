package Main;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
public class ContinueFormFragment implements ActionListener {
    JFrame frame = new JFrame();
    JLabel title = new JLabel("Payment Method");
    ContinueFormFragment(){
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(200, 220, 255));
        GridBagConstraints set = new GridBagConstraints();
        set.insets = new Insets(10, 10, 10, 10);
        set.anchor = GridBagConstraints.CENTER;
        set.fill = GridBagConstraints.HORIZONTAL;

                //NewStudentLabel
                GridBagConstraints labelConstraints = new GridBagConstraints();
                labelConstraints.gridx = 1; 
                labelConstraints.gridy = 0; 
                labelConstraints.gridwidth = 3; 
                labelConstraints.anchor = GridBagConstraints.CENTER;
                labelConstraints.insets = new Insets(20, 10, 10, 10); // for padding lang ito
                title.setFont(new Font("Arial", Font.BOLD, 16));
        
                JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                labelPanel.add(title);
                mainPanel.add(labelPanel, labelConstraints);


        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}

