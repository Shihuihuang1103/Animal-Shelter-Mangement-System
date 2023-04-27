package animalShelter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame {
    public AdminPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        setupPanels();
        setSize(1000,800);
    }

    public void setupPanels (){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JLabel adminPage = new JLabel("Manage Animal Information");
        adminPage.setFont(new Font("Serif", Font.PLAIN, 40));
        adminPage.setLocation(400, 50);
        adminPage.setForeground(new Color(42, 104, 206));
        adminPage.setBackground(new Color(100, 20, 70));

        JButton home = new JButton("Homepage");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
                dispose();
            }
        });

//        JButton backButton = new JButton("Back").addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new AdminPage().setVisible(true);
//            }
//        });
        JButton addButton = new JButton("Add an Animal");
        JButton removeButton = new JButton("Remove an Animal");
        JButton updateButton = new JButton("Update information");

        mainPanel.add(adminPage);
        mainPanel.add(home);
        mainPanel.add(addButton);
        mainPanel.add(removeButton);
        mainPanel.add(updateButton);
        this.add(mainPanel);
    }
}
