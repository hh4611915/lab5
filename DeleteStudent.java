/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ASUS
 */
  import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  
public class DeleteStudent extends javax.swing.JFrame {

    /**
    
     */
 
    private JPanel panel1;
    private JTable table1;
    private JButton deleteButton;
    private JButton backButton;
    private StudentDatabase sb = new StudentDatabase("students.txt");

    public DeleteStudent() {
        initComponents();

        setTitle("Delete Student");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        loadTable();

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a student to delete!");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to delete this student?",
                        "Confirm Deletion",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    sb.readFromFile();
                    int id = (int) table1.getValueAt(row, 0);
                    Student[] arr = sb.studentList();
                    boolean deleted = false;

                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] != null && arr[i].getId() == id) {
                            arr[i] = null;
                            deleted = true;
                            break;
                        }
                    }

                    if (deleted) {
                        sb.saveToFile();
                        JOptionPane.showMessageDialog(null, "Deleted successfully!");
                        loadTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error deleting student!");
                    }
                }
            }
        });

        backButton.addActionListener(e -> setVisible(false));
    }

    private void loadTable() {
        sb.readFromFile();
        String[] header = {"ID", "Name", "Age", "Gender", "Department", "GPA"};
        DefaultTableModel table = new DefaultTableModel(header, 0);

        for (Student s : sb.studentList()) {
            if (s != null) {
                table.addRow(new Object[]{
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getGender(),
                        s.getDepartment(),
                        s.getGpa()
                });
            }
        }

        table1.setModel(table);
    }

    private void initComponents() {
        panel1 = new JPanel();
        table1 = new JTable();
        deleteButton = new JButton();
        backButton = new JButton();

        JScrollPane scrollPane = new JScrollPane(table1);
        deleteButton.setText("Delete");
        backButton.setText("Back");

        GroupLayout layout = new GroupLayout(panel1);
        panel1.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50)
                    .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                    .addGap(50)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                    .addGap(30)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteButton)
                        .addComponent(backButton))
                    .addGap(30))
        );

        setContentPane(panel1);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DeleteStudent());
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
