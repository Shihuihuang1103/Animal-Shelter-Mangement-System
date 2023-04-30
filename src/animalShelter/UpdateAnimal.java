package animalShelter;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateAnimal extends JFrame{
    private JDBC db = new JDBC();
    private Connection connection;
    public UpdateAnimal(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupPanels();
        setBounds(100, 100, 800, 550);
        setVisible(true);
    }

    public void setupPanels(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(246, 246, 246));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(mainPanel);

        JLabel udpate = new JLabel("Update Animal");
        udpate.setHorizontalAlignment(SwingConstants.CENTER);
        udpate.setForeground(new Color(141, 94, 23));
        udpate.setFont(new Font("Lava Kannada", Font.PLAIN, 35));

        JLabel search = new JLabel("Search by Pet ID:");
        search.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField petidInput = new JTextField();
        petidInput.setColumns(10);

        JButton cancel = new JButton("Cancel");

        JButton searchButton = new JButton("Search");

        JLabel petName = new JLabel("Pet Name: ");
        petName.setHorizontalAlignment(SwingConstants.TRAILING);
        petName.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField petnameInput = new JTextField();
        petName.setLabelFor(petnameInput);
        petnameInput.setColumns(10);

        JLabel breed = new JLabel("Breed: ");
        breed.setHorizontalAlignment(SwingConstants.TRAILING);
        breed.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField breedInput = new JTextField();
        breed.setLabelFor(breedInput);
        breedInput.setColumns(10);

        JLabel gender = new JLabel("Gender: ");
        gender.setHorizontalAlignment(SwingConstants.TRAILING);
        gender.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField genderInput = new JTextField();
        gender.setLabelFor(genderInput);
        genderInput.setColumns(10);

        JLabel age = new JLabel("Age: ");
        age.setHorizontalAlignment(SwingConstants.TRAILING);
        age.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField ageInput = new JTextField();
        age.setLabelFor(ageInput);
        ageInput.setColumns(10);

        JLabel description = new JLabel("Description:");
        description.setHorizontalAlignment(SwingConstants.TRAILING);
        description.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton update = new JButton("Update");

        JLabel messageLabel = new JLabel("");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(344)
                                .addComponent(petidInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(316, Short.MAX_VALUE))
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(320)
                                .addComponent(cancel)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(292, Short.MAX_VALUE))
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(217)
                                .addPreferredGap(ComponentPlacement.RELATED, 66, GroupLayout.PREFERRED_SIZE)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(udpate)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(petName)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(petnameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(breed, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(ComponentPlacement.UNRELATED))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(gender, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(genderInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12)
                                                                .addComponent(age, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18)))
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(breedInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ageInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(248, Short.MAX_VALUE))
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addContainerGap(354, Short.MAX_VALUE)
                                .addComponent(search)
                                .addGap(324))
                        .addGroup(Alignment.LEADING, gl_mainPanel.createSequentialGroup()
                                .addGap(257)
                                .addComponent(description, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(411, Short.MAX_VALUE))
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addContainerGap(363, Short.MAX_VALUE)
                                .addComponent(update, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addGap(341))
                        .addGroup(Alignment.LEADING, gl_mainPanel.createSequentialGroup()
                                .addGap(243)
                                .addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(220, Short.MAX_VALUE))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(15)
                                .addComponent(udpate)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(search)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(petidInput, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(cancel)
                                        .addComponent(searchButton))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(breedInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(breed, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(petnameInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(petName))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(ageInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(age, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gender, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(genderInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(description, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(update)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        JTextArea descriptionInput = new JTextArea();
        scrollPane.setViewportView(descriptionInput);
        mainPanel.setLayout(gl_mainPanel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminPage().setVisible(true);
                dispose();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("");
                try {
                    connection = db.getCon();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                int petIDInt = Integer.parseInt(petidInput.getText());
                String checkPetID = "SELECT * FROM animal WHERE petID = ?";
                try {
                    PreparedStatement pst1 = connection.prepareStatement(checkPetID);
                    pst1.setInt(1, petIDInt);
                    ResultSet rs = pst1.executeQuery();
                    if (rs.next()){
                        String nameOutput = rs.getString(2);
                        petnameInput.setText(nameOutput);
                        String breedOutput = rs.getString(3);
                        breedInput.setText(breedOutput);
                        String genderOutput = rs.getString(4);
                        genderInput.setText(genderOutput);
                        int ageOutput = rs.getInt(5);
                        ageInput.setText(String.valueOf(ageOutput));
                        String descriptionOutput = rs.getString(6);
                        descriptionInput.setText(descriptionOutput);
                    } else {
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("Invalid pet ID!");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    connection = db.getCon();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                Boolean allFieldFilled = true;
                int petIDInt;
                if(petidInput.getText().isEmpty()){
                    petIDInt = -1;
                    allFieldFilled = false;
                } else {
                    petIDInt = Integer.parseInt(petidInput.getText());
                }
                String petNameStr = petnameInput.getText();
                String breedStr = breedInput.getText();
                String genderStr = genderInput.getText();
                int ageInt;
                if(ageInput.getText().isEmpty()){
                    ageInt = -1;
                    allFieldFilled = false;
                } else {
                    ageInt = Integer.parseInt(ageInput.getText());
                }
                String descriptionStr = descriptionInput.getText();

                //check if all the fields are filled
                if (petNameStr.isEmpty() || genderStr.isEmpty() || breedStr.isEmpty() || descriptionStr.isEmpty()){
                    allFieldFilled = false;
                }

               if(allFieldFilled){
                   String sql = "UPDATE animal SET name = ?, breed = ?, gender = ?, age = ?, description = ? WHERE petID = ?";
                   try {
                       PreparedStatement pst = connection.prepareStatement(sql);
                       pst.setString(1, petNameStr);
                       pst.setString(2, breedStr);
                       pst.setString(3, genderStr);
                       pst.setInt(4, ageInt);
                       pst.setString(5, descriptionStr);
                       pst.setInt(6, petIDInt);
                       int rowsAffected;
                       if (petIDInt < 0 || ageInt < 0) {
                           rowsAffected = 0;
                       } else {
                           rowsAffected = pst.executeUpdate();
                       }
                       if (rowsAffected > 0) {
                           messageLabel.setForeground(new Color(51, 176, 63));
                           messageLabel.setText("Updated successfully!");
                           petidInput.setText("");
                           petnameInput.setText("");
                           breedInput.setText("");
                           genderInput.setText("");
                           ageInput.setText("");
                           descriptionInput.setText("");
                       } else {
                           messageLabel.setForeground(Color.RED);
                           messageLabel.setText("Something went wrong...");
                       }
                   } catch (SQLException ex) {
                       throw new RuntimeException(ex);
                   }
               } else {
                   messageLabel.setForeground(Color.RED);
                   messageLabel.setText("Please fill all the fields!");
               }

            }
        });
    }
}
