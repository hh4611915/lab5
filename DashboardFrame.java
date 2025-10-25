import javax.swing.*;

public class DashboardFrame extends JFrame {
    public DashboardFrame() {
        setTitle("Dashboard");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("Welcome to Student Management hamza ", SwingConstants.CENTER);
        titleLabel.setBounds(50, 30, 400, 40);
        add(titleLabel);

        JButton addButton = new JButton("Add");
        addButton.setBounds(180, 90, 120, 40);
        add(addButton);

        JButton viewButton = new JButton("View");
        viewButton.setBounds(180, 150, 120, 40);
        add(viewButton);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(180, 210, 120, 40);
        add(searchButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(180, 270, 120, 40);
        add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(180, 330, 120, 40);
        add(deleteButton);
        // 🔹 Button actions
        addButton.addActionListener(e -> {
            dispose();
           // new AddPage();
        });

        viewButton.addActionListener(e -> {
            dispose();
           // new ViewPage();
        });

        searchButton.addActionListener(e -> {
            dispose();
           // new SearchPage();
        });

        updateButton.addActionListener(e -> {
            dispose();
            //new UpdatePage();
        });
        deleteButton.addActionListener(e -> {
            dispose();
           // new DeletePage();
        });

        setVisible(true);
    }
}

