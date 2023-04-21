package animalShelter;

import javax.swing.*;
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
        login.setLocation(400, 50);
        login.setForeground(new Color(65, 162, 159));
        login.setBackground(new Color(100, 20, 70));
        mainPanel.add(login);

        JButton goBack = new JButton("Back");
        mainPanel.add(goBack);

        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
            }
        });
        this.add(mainPanel);
    }
}
