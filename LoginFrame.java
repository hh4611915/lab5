import javax.swing.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JTextField passwordField;

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 300); // Window size
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("Login to Student Management", SwingConstants.CENTER);
        titleLabel.setBounds(50, 30, 300, 30);
        add(titleLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(80, 90, 100, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(180, 90, 140, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(80, 130, 100, 25);
        add(passLabel);

        passwordField = new JTextField();
        passwordField.setBounds(180, 130, 140, 25);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 190, 100, 35);
        add(loginButton);

        // 🔹 Action for login button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if ((username.equals("hamza") && password.equals("123"))||(username.equals("fares") && password.equals("2005"))){
                JOptionPane.showMessageDialog(this, "Login successful!");
                dispose(); // Close login window
                new DashboardFrame(); // Open dashboard
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        });

        setVisible(true);
    }

}

