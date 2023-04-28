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
        setTitle("Adoption");
        setupPanels();
        setBounds(100, 100, 800, 550);
        //setSize(1000, 800);
    }

    public void setupPanels() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(246, 246, 246));

        setContentPane(mainPanel);
        JLabel adopt = new JLabel("Start Your Adoption");
        adopt.setVerticalAlignment(SwingConstants.TOP);
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

        JButton submit = new JButton("Submit");

        JButton home = new JButton("Homepage");

        JLabel messageLabel = new JLabel("");
        messageLabel.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(252)
                                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
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
                                                        .addComponent(statement, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(firstname)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(fnameInput, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(petID, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(petInput, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(349)
                                                .addComponent(submit)))
                                .addContainerGap(211, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                .addContainerGap(222, Short.MAX_VALUE)
                                .addComponent(adopt)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(home, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                .addGap(84))
                        .addGroup(GroupLayout.Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                .addGap(237)
                                .addComponent(scrollPane)
                                .addGap(226))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(adopt)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
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
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(submit))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(23)
                                                .addComponent(home)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTextArea statementInput = new JTextArea();
        scrollPane.setViewportView(statementInput);
        mainPanel.setLayout(gl_mainPanel);

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
                dispose();
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fnameStr = fnameInput.getText();
                String lnameStr = lnameInput.getText();
                String emailStr = emailInput.getText();
                String phoneStr = phoneInput.getText();
                int petIDInt;
                if(petInput.getText().isEmpty()){
                    petIDInt = 0;
                } else {
                    petIDInt = Integer.parseInt(petInput.getText());
                }
                String statementStr = statementInput.getText();

                String sql = "INSERT INTO `adoption` (`email`, `fname`, `lname`, `petID`, `phoneNum`, `statement`) VALUES (?, ?, ?, ?, ?, ?)";
                String checkPetID = "SELECT * FROM animal WHERE petID = ?";
                try {
                    connection = db.getCon();
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1, emailStr);
                    pst.setString(2, fnameStr);
                    pst.setString(3, lnameStr);
                    pst.setInt(4, petIDInt);
                    pst.setString(5, phoneStr);
                    pst.setString(6, statementStr);

                    PreparedStatement pst2 = connection.prepareStatement(checkPetID);
                    pst2.setInt(1, petIDInt);
                    ResultSet rs = pst2.executeQuery();
                    Boolean isValidPetID = rs.next();

                    //if pet ID is not found in the animal table, do not execute query
                    //if any field is empty, do not execute query
                    int rowsAffected;
                    if(!isValidPetID){
                        rowsAffected = 0;
                    } else if (fnameStr.isEmpty() || lnameStr.isEmpty() || emailStr.isEmpty() || phoneStr.isEmpty() || statementStr.isEmpty()){
                        rowsAffected = 0;
                    } else {
                        rowsAffected = pst.executeUpdate();
                    }

                    if(rowsAffected > 0){
                        messageLabel.setForeground(new Color(51, 176, 63));
                        messageLabel.setText("Your adoption form has been submitted successfully!");
                        fnameInput.setText("");
                        lnameInput.setText("");
                        emailInput.setText("");
                        petInput.setText("");
                        phoneInput.setText("");
                        statementInput.setText("");
                    } else if (!isValidPetID){
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("Invalid pet ID!");
                    } else if (fnameStr.isEmpty() || lnameStr.isEmpty() || emailStr.isEmpty() || phoneStr.isEmpty() || statementStr.isEmpty()){
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("Please fill all the fields!");
                    }

//                    else {
//                        messageLabel.setForeground(Color.RED);
//                        messageLabel.setText("Something went wrong!");
//                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
