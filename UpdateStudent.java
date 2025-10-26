import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStudent extends JFrame {
    private JPanel panel;
    private JTextField searchField;
    private JButton searchButton;
    private JTextField textName, textAge, textDepartment, textGPA;
    private JComboBox comboGender;
    private JButton updateButton, backButton;
    private StudentDatabase sb = new StudentDatabase("students.txt");
    private Validation v = new Validation();
    private Student currentStudent;

    public UpdateStudent() {
        setSize(500, 550);
        setLocationRelativeTo(null);
        setTitle("Update Student");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        if (panel == null) {
            panel = new JPanel();
            panel.setLayout(null);

            JLabel searchLabel = new JLabel("Enter Student ID to search:");
            searchLabel.setBounds(30, 20, 180, 25);
            panel.add(searchLabel);

            searchField = new JTextField();
            searchField.setBounds(210, 20, 150, 25);
            panel.add(searchField);

            searchButton = new JButton("Search");
            searchButton.setBounds(370, 20, 80, 25);
            panel.add(searchButton);

            JLabel nameLabel = new JLabel("Name:");
            nameLabel.setBounds(50, 70, 100, 25);
            panel.add(nameLabel);

            textName = new JTextField();
            textName.setBounds(150, 70, 200, 25);
            panel.add(textName);

            JLabel ageLabel = new JLabel("Age:");
            ageLabel.setBounds(50, 110, 100, 25);
            panel.add(ageLabel);

            textAge = new JTextField();
            textAge.setBounds(150, 110, 200, 25);
            panel.add(textAge);

            JLabel genderLabel = new JLabel("Gender:");
            genderLabel.setBounds(50, 150, 100, 25);
            panel.add(genderLabel);

            comboGender = new JComboBox(new String[]{"Male", "Female"});
            comboGender.setBounds(150, 150, 200, 25);
            panel.add(comboGender);

            JLabel deptLabel = new JLabel("Department:");
            deptLabel.setBounds(50, 190, 100, 25);
            panel.add(deptLabel);

            textDepartment = new JTextField();
            textDepartment.setBounds(150, 190, 200, 25);
            panel.add(textDepartment);

            JLabel gpaLabel = new JLabel("GPA:");
            gpaLabel.setBounds(50, 230, 100, 25);
            panel.add(gpaLabel);

            textGPA = new JTextField();
            textGPA.setBounds(150, 230, 200, 25);
            panel.add(textGPA);

            updateButton = new JButton("Update");
            updateButton.setBounds(150, 280, 100, 30);
            panel.add(updateButton);

            backButton = new JButton("Back");
            backButton.setBounds(260, 280, 100, 30);
            panel.add(backButton);
        }

        setContentPane(panel);
        setVisible(true);

        sb.readFromFile();

        searchButton.addActionListener(e -> {
            String idText = searchField.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter an ID to search!");
                return;
            }
            try {
                int id = Integer.parseInt(idText);
                currentStudent = null;
                for (Student s : sb.studentList()) {
                    if (s.getId() == id) {
                        currentStudent = s;
                        break;
                    }
                }
                if (currentStudent == null) {
                    JOptionPane.showMessageDialog(null, "Student not found!");
                } else {
                    textName.setText(currentStudent.getName());
                    textAge.setText(String.valueOf(currentStudent.getAge()));
                    comboGender.setSelectedItem(currentStudent.getGender());
                    textDepartment.setText(currentStudent.getDepartment());
                    textGPA.setText(String.valueOf(currentStudent.getGpa()));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Enter a valid numeric ID!");
            }
        });

        updateButton.addActionListener(e -> {
            if (currentStudent == null) {
                JOptionPane.showMessageDialog(null, "Search a student first!");
                return;
            }

            String name = textName.getText();
            if (!v.nameValidaion(name)) {
                JOptionPane.showMessageDialog(null, "Enter a valid name!");
                return;
            }

            String ageText = textAge.getText();
            if (!v.ageValidaion(ageText)) {
                JOptionPane.showMessageDialog(null, "Enter a valid age!");
                return;
            }
            int age = Integer.parseInt(ageText);

            Object genderObj = comboGender.getSelectedItem();
            if (genderObj == null) {
                JOptionPane.showMessageDialog(null, "Select a gender!");
                return;
            }
            String gender = genderObj.toString();

            String department = textDepartment.getText();
            if (!v.nameValidaion(department)) {
                JOptionPane.showMessageDialog(null, "Enter a valid department!");
                return;
            }

            String gpaText = textGPA.getText();
            if (!v.gpaValidaion(gpaText)) {
                JOptionPane.showMessageDialog(null, "Enter a valid GPA!");
                return;
            }
            double gpa = Double.parseDouble(gpaText);

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to save changes?");
            if (choice == 0) {
                currentStudent.setName(name);
                currentStudent.setAge(age);
                currentStudent.setGender(gender);
                currentStudent.setDepartment(department);
                currentStudent.setGpa(gpa);

                sb.saveToFile();

                JOptionPane.showMessageDialog(null, "Student updated successfully!");
                new DashboardFrame();
                setVisible(false);
            }
        });

        backButton.addActionListener(e -> {
            new DashboardFrame();
            setVisible(false);
        });
    }
}
