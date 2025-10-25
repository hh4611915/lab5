import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewStudent extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton backButton;
    private StudentDatabase sb = new StudentDatabase("students.txt");

    public ViewStudent() {
        boolean flag = false;
        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setTitle("View Students");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        sb.readFromFile();
        String[] firstRow = {"ID","Name","Age","Gender","Department","GPA"};
        DefaultTableModel table = new DefaultTableModel(firstRow,0);
        Student[] students = sb.studentList();
        for(int i=0;i<students.length;i++){
            Object[] rows = {students[i].getId(),students[i].getName(),students[i].getAge(),students[i].getGender()
                    ,students[i].getDepartment(),students[i].getGpa()};
            table.addRow(rows);
            flag = true;
        }
        table1.setModel(table);
        if(!flag){
            JOptionPane.showMessageDialog(null,"There is no students in the file");
        }


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DashboardFrame();
                setVisible(false);
            }
        });
    }
    }

