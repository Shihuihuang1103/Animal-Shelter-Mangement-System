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

        JButton home = new JButton("Homepage");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
            }
        });

        mainPanel.add(adopt);
        mainPanel.add(home);

        //User input info for adoption
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5,1));
        JLabel firstname = new JLabel("Your Firstname: ", JLabel.TRAILING);
        JTextField fnameInput = new JTextField(30);
        firstname.setLabelFor(fnameInput);

        JLabel lastname = new JLabel("Your Lastname: ", JLabel.TRAILING);
        JTextField lnameInput = new JTextField(30);
        lastname.setLabelFor(lnameInput);

        JLabel email = new JLabel("Email Address: ", JLabel.TRAILING);
        JTextField emailInput = new JTextField(30);
        email.setLabelFor(emailInput);

        JLabel phone = new JLabel("Phone Number: ", JLabel.TRAILING);
        JTextField phoneInput = new JTextField(30);
        phone.setLabelFor(phoneInput);

        JLabel petID = new JLabel("petID: ", JLabel.TRAILING);
        JTextField petInput = new JTextField(30);

        inputPanel.add(firstname);
        inputPanel.add(fnameInput);
        inputPanel.add(lastname);
        inputPanel.add(lnameInput);
        inputPanel.add(email);
        inputPanel.add(emailInput);
        inputPanel.add(phone);
        inputPanel.add(phoneInput);
        inputPanel.add(petID);
        inputPanel.add(petInput);
        mainPanel.add(inputPanel);


        JPanel statementPanel = new JPanel();
        JLabel statement = new JLabel("My Statement (up to 500 words): ", JLabel.TRAILING);
        JTextArea statementInput = new JTextArea(20,40);

        statementPanel.add(statement);
        statementPanel.add(statementInput);
        mainPanel.add(statementPanel);

        JButton submit = new JButton("submit");
        mainPanel.add(submit);

        this.add(mainPanel);
    }
}
