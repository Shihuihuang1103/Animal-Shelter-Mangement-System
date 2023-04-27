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
        appointment.setForeground(new Color(42, 104, 206));
        appointment.setBackground(new Color(100, 20, 70));

        JButton home = new JButton("Homepage");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
                dispose();
            }
        });

        mainPanel.add(appointment);
        mainPanel.add(home);

        //User input for appointment
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4,1));
        JLabel firstname = new JLabel("Your Firstname: ", JLabel.TRAILING);
        JTextField fnameInput = new JTextField(30);
        firstname.setLabelFor(fnameInput);

        JLabel lastname = new JLabel("Your Lastname: ", JLabel.TRAILING);
        JTextField lnameInput = new JTextField(30);
        lastname.setLabelFor(lnameInput);

        JLabel email = new JLabel("Email Address: ", JLabel.TRAILING);
        JTextField emailInput = new JTextField(30);
        email.setLabelFor(emailInput);

        JLabel dateTime = new JLabel("Select Date and Time: ", JLabel.TRAILING);

        inputPanel.add(firstname);
        inputPanel.add(fnameInput);
        inputPanel.add(lastname);
        inputPanel.add(lnameInput);
        inputPanel.add(email);
        inputPanel.add(emailInput);
        inputPanel.add(dateTime);
        mainPanel.add(inputPanel);

        JButton submit = new JButton("submit");
        mainPanel.add(submit);

        this.add(mainPanel);
    }
}

