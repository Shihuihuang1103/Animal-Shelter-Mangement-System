package animalShelter;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class AddAnimal extends JFrame {
    private JDBC db = new JDBC();
    private Connection connection;

    private JPanel mainPanel;
    private JTextField petidInput;
    private JTextField petnameInput;
    private JTextField breedInput;
    private JTextField genderInput;
    private JTextField ageInput;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddAnimal frame = new AddAnimal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AddAnimal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 550);
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(246, 246, 246));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(mainPanel);

        JLabel addAnimal = new JLabel("Add Animal");
        addAnimal.setForeground(new Color(142, 95, 23));
        addAnimal.setHorizontalAlignment(SwingConstants.CENTER);
        addAnimal.setFont(new Font("Lava Kannada", Font.PLAIN, 40));

        JLabel petID = new JLabel("Pet ID: ");
        petID.setHorizontalAlignment(SwingConstants.TRAILING);
        petID.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JLabel messageLabel = new JLabel("");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        petidInput = new JTextField();
        petidInput.setColumns(10);

        JLabel petName = new JLabel("Pet Name: ");
        petName.setHorizontalAlignment(SwingConstants.TRAILING);
        petName.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        petnameInput = new JTextField();
        petName.setLabelFor(petnameInput);
        petnameInput.setColumns(10);

        JLabel breed = new JLabel("Breed: ");
        breed.setHorizontalAlignment(SwingConstants.TRAILING);
        breed.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        breedInput = new JTextField();
        breed.setLabelFor(breedInput);
        breedInput.setColumns(10);

        JLabel gender = new JLabel("Gender: ");
        gender.setHorizontalAlignment(SwingConstants.TRAILING);
        gender.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        genderInput = new JTextField();
        gender.setLabelFor(genderInput);
        genderInput.setColumns(10);

        JLabel age = new JLabel("Age: ");
        age.setHorizontalAlignment(SwingConstants.TRAILING);
        age.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        ageInput = new JTextField();
        age.setLabelFor(ageInput);
        ageInput.setColumns(10);

        JLabel description = new JLabel("Description: ");
        description.setHorizontalAlignment(SwingConstants.TRAILING);
        description.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton back = new JButton("Go Back");

        JButton submit = new JButton("Submit");
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(283)
                                                .addComponent(addAnimal))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(231)
                                                .addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addGap(192)
                                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                                                                        .addComponent(petName, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(petID)
                                                                        .addComponent(breed, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(gender, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(age, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(description, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                                                .addContainerGap(236, Short.MAX_VALUE)
                                                                .addComponent(back)
                                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(ageInput, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(genderInput, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(breedInput, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(petnameInput, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(petidInput, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addGap(76)
                                                                .addComponent(submit, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(234, Short.MAX_VALUE))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(16)
                                .addComponent(addAnimal)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(petID)
                                        .addComponent(petidInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(petName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(petnameInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(breed, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(breedInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(gender, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(genderInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(age, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ageInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(16)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(description, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(submit)
                                        .addComponent(back))
                                .addGap(25))
        );

        JTextArea descriptionInput = new JTextArea();
        scrollPane.setViewportView(descriptionInput);
        mainPanel.setLayout(gl_mainPanel);

        submit.addActionListener(new ActionListener() {
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

                //check if petID already exists
                Boolean repeatedID;
                String checkPetID = "SELECT * FROM animal WHERE petID = ?";
                try {
                    PreparedStatement pst1 = connection.prepareStatement(checkPetID);
                    pst1.setInt(1, petIDInt);
                    ResultSet rs = pst1.executeQuery();
                    if (rs.next()) {
                        repeatedID = true;
                    } else {
                        repeatedID = false;
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                //if all the fields are filled and pet ID is available, execute sql
                if(allFieldFilled && !repeatedID) {
                    String sql = "INSERT INTO `animal` (`petID`, `name`, `breed`, `gender`, `age`, `description`) VALUES (?,?,?,?,?,?)";
                    try {
                        PreparedStatement pst2 = connection.prepareStatement(sql);
                        pst2.setInt(1, petIDInt);
                        pst2.setString(2, petNameStr);
                        pst2.setString(3, breedStr);
                        pst2.setString(4, genderStr);
                        pst2.setInt(5, ageInt);
                        pst2.setString(6, descriptionStr);
                        int rowsAffected;
                        if (petIDInt < 0 || ageInt < 0) {
                            rowsAffected = 0;
                        } else {
                            rowsAffected = pst2.executeUpdate();
                        }
                        if (rowsAffected > 0) {
                            messageLabel.setForeground(new Color(51, 176, 63));
                            messageLabel.setText("New animal added successfully!");
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
                } else if (repeatedID) {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Pet ID already in exists!");
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Please fill all the fields!");
                }

            }
        });


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminPage().setVisible(true);
                dispose();
            }
        });
    }
}
