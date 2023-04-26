package animalShelter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

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
            }
        });
        this.add(mainPanel);
    }
}
