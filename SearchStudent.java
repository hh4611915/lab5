import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchStudent extends JFrame {
    private JPanel panel;
    private JTextField searchField;
    private JButton searchButton;
    private JTable table;
    private JButton backButton;
    private StudentDatabase sb = new StudentDatabase("students.txt");

    public SearchStudent() {
        setSize(600, 500);
        setLocationRelativeTo(null);
        setTitle("Search Student");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        JLabel searchLabel = new JLabel("Enter Student ID or Name:");
        searchLabel.setBounds(30, 20, 200, 25);
        panel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(230, 20, 200, 25);
        panel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(450, 20, 100, 25);
        panel.add(searchButton);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 70, 520, 300);
        panel.add(scrollPane);

        backButton = new JButton("Back");
        backButton.setBounds(250, 390, 100, 30);
        panel.add(backButton);

        setContentPane(panel);
        sb.readFromFile();

        searchButton.addActionListener(e -> {
            String key = searchField.getText().trim();
            if (key.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter ID or Name to search!");
                return;
            }

            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Gender", "Department", "GPA"}, 0);
            boolean found = false;
            for (Student s : sb.studentList()) {
                if (key.equalsIgnoreCase(s.getName()) || key.equals(String.valueOf(s.getId()))) {
                    model.addRow(new Object[]{s.getId(), s.getName(), s.getAge(), s.getGender(), s.getDepartment(), s.getGpa()});
                    found = true;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "No matching student found!");
            }

            table.setModel(model);
        });

        backButton.addActionListener(e -> setVisible(false));
        new DashboardFrame();
        setVisible(true);
    }
}
