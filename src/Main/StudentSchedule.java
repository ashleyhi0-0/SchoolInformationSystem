package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StudentSchedule extends JPanel {

    public StudentSchedule() {
        // Set the layout for the panel
        setLayout(new BorderLayout());

        // Grade-level schedules
        Map<Integer, Map<String, String>> gradeSchedules = new HashMap<>();
        gradeSchedules.put(1, Map.of(
                "Monday", "Math 8:00-9:00", 
                "Tuesday", "English 9:15-10:15",
                "Wednesday", "Science 8:00-9:00",
                "Thursday", "Art 9:15-10:15",
                "Friday", "Music 8:00-9:00, PE 9:15-10:15"
        ));
        gradeSchedules.put(2, Map.of(
                "Monday", "Math 9:00-10:00, English 10:15-11:15",
                "Wednesday", "History 9:00-10:00, Science 10:15-11:15",
                "Friday", "Music 9:00-10:00, PE 10:15-11:15"
        ));
        gradeSchedules.put(3, Map.of(
                "Monday", "Math 10:00-11:00, English 11:15-12:15",
                "Wednesday", "History 10:00-11:00, Art 11:15-12:15",
                "Friday", "Science 10:00-11:00, Music 11:15-12:15"
        ));
        gradeSchedules.put(4, Map.of(
                "Monday", "Math 8:30-9:30, English 9:45-10:45",
                "Wednesday", "Science 8:30-9:30, History 9:45-10:45",
                "Friday", "Art 8:30-9:30, Music 9:45-10:45"
        ));
        gradeSchedules.put(5, Map.of(
                "Monday", "Math 9:30-10:30, Science 10:45-11:45",
                "Wednesday", "History 9:30-10:30, PE 10:45-11:45",
                "Friday", "Art 9:30-10:30, Music 10:45-11:45"
        ));
        gradeSchedules.put(6, Map.of(
                "Monday", "Math 10:30-11:30, English 11:45-12:45",
                "Wednesday", "History 10:30-11:30, Science 11:45-12:45",
                "Friday", "PE 10:30-11:30, Art 11:45-12:45"
        ));

        // Create a table for the schedule
        String[] columns = {"Day", "Classes"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        // Create a JComboBox for selecting the grade level
        JComboBox<Integer> gradeSelector = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6});
        gradeSelector.setSelectedIndex(0); // Default to Grade 1

        // Update the table when the grade level is selected
        gradeSelector.addActionListener(e -> {
            int selectedGrade = (int) gradeSelector.getSelectedItem();
            updateScheduleTable(tableModel, gradeSchedules.get(selectedGrade));
        });

        // Add the initial schedule for Grade 1
        updateScheduleTable(tableModel, gradeSchedules.get(1));

        // Layout components
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(new JLabel("Select Grade Level:"));
        bottomPanel.add(gradeSelector);
        add(bottomPanel, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Student Schedule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(this); 
        frame.setVisible(true);
    }

    private void updateScheduleTable(DefaultTableModel tableModel, Map<String, String> schedule) {
        // Clear the table
        tableModel.setRowCount(0);

        // Populate the table with the selected grade's schedule
        for (Map.Entry<String, String> entry : schedule.entrySet()) {
            tableModel.addRow(new Object[]{entry.getKey(), entry.getValue()});
        }
    }
}
