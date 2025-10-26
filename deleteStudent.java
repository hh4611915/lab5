import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class deleteStudent extends JFrame {

    private JPanel deletPanel;
    private JTable table1;
    private JButton backButton;
    private JButton deletButton;
    private StudentDatabase sd = new StudentDatabase("students.txt");

    public deleteStudent(){
        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setContentPane(deletPanel);
        setTitle("Delete Students");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        sd.readFromFile();

        String[] firstRow = {"ID","Name","Age","Gender","Department","GPA"};
        DefaultTableModel table = new DefaultTableModel(firstRow,0);
        Student[] students = sd.studentList();
        for(int i=0;i<students.length;i++){
            Object[] rows = {students[i].getId(),students[i].getName(),students[i].getAge(),students[i].getGender()
                    ,students[i].getDepartment(),students[i].getGpa()};
            table.addRow(rows);
        }
        table1.setModel(table);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        deletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Select a student from the table");
                }else{
                    int id = (int) table1.getValueAt(selectedRow, 0);
                    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete student with ID: " + id + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                    if(confirmation == JOptionPane.YES_OPTION){
                        sd.deleteStudent(id);
                        table.setRowCount(0);
                        Student[] students = sd.studentList();
                        for(int i=0;i<students.length;i++){
                            Object[] rows = {students[i].getId(),students[i].getName(),students[i].getAge(),students[i].getGender()
                                    ,students[i].getDepartment(),students[i].getGpa()};
                            table.addRow(rows);
                        }
                        table1.setModel(table);
                        JOptionPane.showMessageDialog(null,"student with ID: " + id + " has been deleted");
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sd.resetCounter();
                new DashboardFrame();
                setVisible(false);
            }
        });
    }
}


