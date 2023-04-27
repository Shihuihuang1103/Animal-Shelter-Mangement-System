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
        mainPanel.setLayout(new BorderLayout());
        JPanel banner = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        banner.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;


        //load and add logo img
        try{
            BufferedImage img = ImageIO.read(new File("src/logo/lovepaw.jpeg"));
            Image newimage = img.getScaledInstance(50,50,Image.SCALE_DEFAULT);
            JLabel image = new JLabel(new ImageIcon(newimage));
            image.setHorizontalAlignment(JLabel.RIGHT);
            layout.setConstraints(image,gbc);
            banner.add(image);
        }catch (IOException e){
            e.getMessage();
        }

        // Add shelter name banner
        JLabel welcome = new JLabel("Lovely Paws Animal Shelter");
        welcome.setFont(new Font("Serif", Font.PLAIN, 40));
        welcome.setHorizontalAlignment(JLabel.LEFT);
        welcome.setForeground(new Color(120, 90, 40));
        welcome.setBackground(new Color(100, 20, 70));

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        layout.setConstraints(welcome,gbc);
        banner.add(welcome);
        mainPanel.add(banner, BorderLayout.NORTH);

        // Add 3 buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton login = new JButton("Admin Login");
        JButton appointment = new JButton("Make an Appointment");
        JButton adopt = new JButton("Adopt A Pet");


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                dispose();
            }
        });

        appointment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Appointment().setVisible(true);
                dispose();
            }
        });

        adopt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Adopt().setVisible(true);
                dispose();
            }
        });

        buttonPanel.add(login);
        buttonPanel.add(appointment);
        buttonPanel.add(adopt);
        mainPanel.add(buttonPanel);

        this.add(mainPanel);

    }


    public static void main(String[] args)  {
        // Create a new instance of the LoginGUI class
        Main page = new Main();
    }
}




