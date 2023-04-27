package animalShelter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Adopt extends JFrame {

    private JDBC db = new JDBC();
    private Connection connection;

    public Adopt() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        setupPanels();
        setBounds(100, 100, 800, 550);
        //setSize(1000, 800);
    }

    public void setupPanels() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(246, 246, 246));

        setContentPane(mainPanel);

        JLabel adopt = new JLabel("Start Your Adoption");
        adopt.setHorizontalAlignment(SwingConstants.CENTER);
        adopt.setForeground(new Color(246, 148, 67));
        adopt.setFont(new Font("Lava Kannada", Font.PLAIN, 40));

        JLabel firstname = new JLabel("Firstname:");
        firstname.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField fnameInput = new JTextField();
        firstname.setLabelFor(fnameInput);
        fnameInput.setColumns(10);

        JLabel lastname = new JLabel("Lastname:");
        lastname.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField lnameInput = new JTextField();
        lastname.setLabelFor(lnameInput);
        lnameInput.setColumns(10);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField emailInput = new JTextField();
        email.setLabelFor(emailInput);
        emailInput.setColumns(10);

        JLabel phone = new JLabel("Phone: ");
        phone.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField phoneInput = new JTextField();
        phone.setLabelFor(phoneInput);
        phoneInput.setColumns(10);

        JLabel petID = new JLabel("Pet ID:");
        petID.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField petInput = new JTextField();
        petID.setLabelFor(petInput);
        petInput.setColumns(10);

        JLabel statement = new JLabel("Statement: (up to 500 words)");
        statement.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextArea statementInput = new JTextArea();

        JButton submit = new JButton("Submit");

        JButton home = new JButton("Homepage");
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(215)
                                                .addComponent(adopt))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(252)
                                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(lastname, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lnameInput, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(email, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(emailInput, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(phone, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(phoneInput, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(petID, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(petInput, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(statement, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(statementInput)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(firstname)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(home, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(fnameInput, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(349)
                                                .addComponent(submit)))
                                .addContainerGap(215, Short.MAX_VALUE))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(11)
                                .addComponent(adopt)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(firstname)
                                        .addComponent(fnameInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lastname, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lnameInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(phone, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(petID, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(petInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(statement, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statementInput, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(submit)
                                .addContainerGap(23, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                .addContainerGap(63, Short.MAX_VALUE)
                                .addComponent(home)
                                .addGap(420))
        );
        mainPanel.setLayout(gl_mainPanel);

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
                dispose();
            }
        });

        mainPanel.add(adopt);
        mainPanel.add(home);

        //User input info for adoption
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5,1));

        JLabel messageLabel = new JLabel();
        messageLabel.setForeground(Color.red);
        mainPanel.add(messageLabel);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fnameStr = fnameInput.getText();
                String lnameStr = lnameInput.getText();
                String emailStr = emailInput.getText();
                String phoneStr = phoneInput.getText();
                int petIDInt = Integer.parseInt(petInput.getText());
                String statementStr = statementInput.getText();

                String sql = "INSERT INTO `adoption` (`email`, `fname`, `lname`, `petID`, `phoneNum`, `statement`) VALUES (?, ?, ?, ?, ?, ?)";
                try {
                    connection = db.getCon();
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1, emailStr);
                    pst.setString(2, fnameStr);
                    pst.setString(3, lnameStr);
                    pst.setInt(4, petIDInt);
                    pst.setString(5, phoneStr);
                    pst.setString(6, statementStr);
                    int rowsAffected = pst.executeUpdate();
                    if(rowsAffected > 0){
                        messageLabel.setText("Your adoption form has been submitted successfully!");
                    } else {
                        messageLabel.setText("Something went wrong!");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        mainPanel.add(submit);

    }
}
