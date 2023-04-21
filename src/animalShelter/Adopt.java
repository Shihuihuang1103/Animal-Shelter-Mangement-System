package animalShelter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Adopt extends JFrame {

    public Adopt() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        setupPanels();
        setSize(1000, 800);
    }

    public void setupPanels() {
        JPanel mainPanel = new JPanel();
        JLabel adopt = new JLabel("Adopt A Pet");
        adopt.setFont(new Font("Serif", Font.PLAIN, 40));
        adopt.setLocation(400, 50);
        adopt.setForeground(new Color(220, 110, 52));
        adopt.setBackground(new Color(100, 20, 70));

        JButton goBack = new JButton("Back");
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
            }
        });

        mainPanel.add(adopt);
        mainPanel.add(goBack);

        this.add(mainPanel);
    }
}
