package animalShelter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Appointment extends JFrame {

    public Appointment() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        setupPanels();
        setSize(1000,800);
    }

    public void setupPanels()  {
        JPanel mainPanel = new JPanel();
        JLabel appointment = new JLabel("Make An Appointment");
        appointment.setFont(new Font("Serif", Font.PLAIN, 40));
        appointment.setLocation(400, 50);
        appointment.setForeground(new Color(220, 110, 159));
        appointment.setBackground(new Color(100, 20, 70));

        JButton goBack = new JButton("Back");
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
            }
        });

        mainPanel.add(appointment);
        mainPanel.add(goBack);

        this.add(mainPanel);
    }
}

