import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends JFrame {
    private StudentDatabase sd = new StudentDatabase("students.txt");
    private JTextField textName;
    private JTextField textAge;
    private JComboBox comboBox1;
    private JPanel p1;
    private JTextField textDeparment;
    private JTextField textGPA;
    private JButton addButton;
    private JButton backButton;
    private Validation v = new Validation();

    public AddStudent() {
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(p1);
        setLocationRelativeTo(null);
        setTitle("Add Student Menu");


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                if(!v.nameValidaion(name))
                {
                    JOptionPane.showMessageDialog(null,"Enter a valid name!");
                    return;
                }
                String line = textAge.getText();
                int age;
                if(!v.ageValidaion(line))
                {
                    JOptionPane.showMessageDialog(null,"Enter a valid age!");
                    return;
                }
                else
                    age = Integer.parseInt(line);

                Object genders = comboBox1.getSelectedItem();
                if(genders == null)
                {
                    JOptionPane.showMessageDialog(null,"Select a Gender!");
                    return;
                }
                String gender = comboBox1.getSelectedItem().toString();
                String department = textDeparment.getText();
                if(!v.nameValidaion(department))
                {
                    JOptionPane.showMessageDialog(null,"Enter a valid department!");
                    return;
                }
                line = textGPA.getText();
                if(!v.gpaValidaion(line)){
                    JOptionPane.showMessageDialog(null,"Enter a valid GPA!");
                    return;
                }
                double gpa = Double.parseDouble(line);
                int choice = JOptionPane.showConfirmDialog(null,"Do you want to save your choice");
                if(choice == 0)
                {
                    sd.readFromFile();
                    sd.addStudent(name,age,gender,department,gpa);
                    sd.saveToFile();
                    JOptionPane.showMessageDialog(null,"Saved Successfully!");
                    //new Menu(); when we create menu it will go back
                    //setVisible(false);
                }
                else if(choice == 1){
                    JOptionPane.showMessageDialog(null,"The progress was not saved!");
                    //new Menu(); when we create menu it will go back
                    //setVisible(false);
                }
                else return;


            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new Menu() should go back when we make menu
                setVisible(false);
            }
        });
    }
}
