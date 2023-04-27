package animalShelter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
    private JDBC db = new JDBC();
    private Connection connection;

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        setupPanels();
        setSize(1000,800);
    }

    public void setupPanels()  {
        JPanel mainPanel = new JPanel();

        JLabel login = new JLabel("Admin Login");
        login.setFont(new Font("Serif", Font.PLAIN, 40));
        login.setLocation(250, 50);
        login.setForeground(new Color(65, 162, 159));
        login.setBackground(new Color(100, 20, 70));
        mainPanel.add(login);
        JButton home = new JButton("Homepage");
        mainPanel.add(home);
        JLabel messageLabel = new JLabel();
        messageLabel.setForeground(Color.red);
        mainPanel.add(messageLabel);

        // Admin input username and password
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2,1));
        JLabel username = new JLabel("Username: ", JLabel.TRAILING);

        JTextField usernameInput = new JTextField(30);
        username.setLabelFor(usernameInput);

        JLabel pswd = new JLabel("Password: ", JLabel.TRAILING);

        JTextField pswdInput = new JTextField(30);
        pswd.setLabelFor(pswdInput);
        inputPanel.add(username);
        inputPanel.add(usernameInput);
        inputPanel.add(pswd);
        inputPanel.add(pswdInput);
        mainPanel.add(inputPanel);

        JButton loginButton = new JButton("Login");
        mainPanel.add(loginButton);

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
                dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameStr = usernameInput.getText();
                String pswdStr = pswdInput.getText();

                String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
                try {
                    connection = db.getCon();
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1, usernameStr);
                    pst.setString(2, pswdStr);
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()){
                        //login succeeded, redirect to next page
                        messageLabel.setText("Login succeeded!");
                        new AdminPage().setVisible(true);
                    } else {
                        //login failed
                        messageLabel.setText("Login failed. Please check your username and password.");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        this.add(mainPanel);
    }
}
