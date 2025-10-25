/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStudent extends javax.swing.JFrame {

    /**
     * Creates new form UpdateStudent
     */
     private JPanel panel1;
    private JTextField textId;
    private JTextField textName;
    private JTextField textAge;
    private JComboBox<String> comboGender;
    private JTextField textDepartment;
    private JTextField textGPA;
    private JButton updateButton;
    private JButton backButton;
    private JButton searchButton;

    private StudentDatabase sb = new StudentDatabase("students.txt");
    private Validation v = new Validation();

    public UpdateStudent() {
        initComponents();

        setTitle("Update Student");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        searchButton.addActionListener(e -> {
            sb.readFromFile();
            String idText = textId.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter student ID to search!");
                return;
            }
            int id = Integer.parseInt(idText);
            for (Student s : sb.studentList()) {
                if (s.getId() == id) {
                    textName.setText(s.getName());
                    textAge.setText(String.valueOf(s.getAge()));
                    comboGender.setSelectedItem(s.getGender());
                    textDepartment.setText(s.getDepartment());
                    textGPA.setText(String.valueOf(s.getGpa()));
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Student not found!");
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sb.readFromFile();
                String idText = textId.getText().trim();
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter ID first!");
                    return;
                }

                int id = Integer.parseInt(idText);
                String name = textName.getText();
                String dept = textDepartment.getText();
                String gender = comboGender.getSelectedItem().toString();
                String ageText = textAge.getText();
                String gpaText = textGPA.getText();

                if (!v.nameValidaion(name) || !v.ageValidaion(ageText) || !v.nameValidaion(dept) || !v.gpaValidaion(gpaText)) {
                    JOptionPane.showMessageDialog(null, "Invalid input data!");
                    return;
                }

                int age = Integer.parseInt(ageText);
                double gpa = Double.parseDouble(gpaText);
                sb.readFromFile();
                Student[] arr = sb.studentList();
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].getId() == id) {
                        arr[i] = new Student(name, age, gender, dept, gpa);
                        JOptionPane.showMessageDialog(null, "Updated Successfully!");
                        sb.saveToFile();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Student not found!");
            }
        });

        backButton.addActionListener(e -> setVisible(false));
    }

    private void initComponents() {
        panel1 = new JPanel();
        textId = new JTextField();
        textName = new JTextField();
        textAge = new JTextField();
        comboGender = new JComboBox<>(new String[]{"Male", "Female"});
        textDepartment = new JTextField();
        textGPA = new JTextField();
        updateButton = new JButton("Update");
        backButton = new JButton("Back");
        searchButton = new JButton("Search");

        JLabel labelId = new JLabel("ID:");
        JLabel labelName = new JLabel("Name:");
        JLabel labelAge = new JLabel("Age:");
        JLabel labelGender = new JLabel("Gender:");
        JLabel labelDepartment = new JLabel("Department:");
        JLabel labelGPA = new JLabel("GPA:");

        GroupLayout layout = new GroupLayout(panel1);
        panel1.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(labelId)
                        .addComponent(labelName)
                        .addComponent(labelAge)
                        .addComponent(labelGender)
                        .addComponent(labelDepartment)
                        .addComponent(labelGPA))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(textId)
                        .addComponent(textName)
                        .addComponent(textAge)
                        .addComponent(comboGender)
                        .addComponent(textDepartment)
                        .addComponent(textGPA)))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(searchButton)
                    .addComponent(updateButton)
                    .addComponent(backButton))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(textId))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName)
                    .addComponent(textName))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAge)
                    .addComponent(textAge))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGender)
                    .addComponent(comboGender))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDepartment)
                    .addComponent(textDepartment))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGPA)
                    .addComponent(textGPA))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(updateButton)
                    .addComponent(backButton))
        );

        setContentPane(panel1);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UpdateStudent());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
