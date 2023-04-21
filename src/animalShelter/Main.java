package animalShelter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame{

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        setupPanels();
        setSize(1000,800);
        setVisible(true);
    }

    public void setupPanels()  {
        JPanel mainPanel = new JPanel();

        JLabel welcome = new JLabel("Lovely Paws Animal Shelter");
        welcome.setFont(new Font("Serif", Font.PLAIN, 40));
        welcome.setLocation(400, 50);
        welcome.setForeground(new Color(120, 90, 40));
        welcome.setBackground(new Color(100, 20, 70));
        mainPanel.add(welcome);

        JButton login = new JButton("Admin Login");
        JButton appointment = new JButton("Make an Appointment");
        JButton adopt = new JButton("Adopt A Pet");

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
            }
        });

        appointment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Appointment().setVisible(true);
            }
        });

        adopt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Adopt().setVisible(true);
            }
        });

        mainPanel.add(login);
        mainPanel.add(appointment);
        mainPanel.add(adopt);

        this.add(mainPanel);

    }


    public static void main(String[] args)  {
        // Create a new instance of the LoginGUI class
        Main page = new Main();
    }
}




