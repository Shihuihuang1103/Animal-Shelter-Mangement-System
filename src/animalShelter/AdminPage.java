package animalShelter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame {
    private JPanel mainPanel;

    public AdminPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 550);
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(246, 246, 246));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(mainPanel);

        JLabel manageInformation = new JLabel("Manage Information");
        manageInformation.setForeground(Color.DARK_GRAY);
        manageInformation.setHorizontalAlignment(SwingConstants.CENTER);
        manageInformation.setFont(new Font("Lava Kannada", Font.PLAIN, 40));

        JButton logOutButton = new JButton("Log Out");
        logOutButton.setForeground(Color.RED);
        logOutButton.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JButton removeButton = new JButton("Remove Animal");
        removeButton.setFont(new Font("Lava Kannada", Font.PLAIN, 18));


        JButton updateButton = new JButton("Update Animal");
        updateButton.setFont(new Font("Lava Kannada", Font.PLAIN, 18));

        JButton addButton = new JButton("Add Animal");
        addButton.setBackground(Color.WHITE);
        addButton.setFont(new Font("Lava Kannada", Font.PLAIN, 18));
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addContainerGap(222, Short.MAX_VALUE)
                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                                .addComponent(manageInformation, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
                                                .addGap(146))
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                                .addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                .addGap(318))
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(removeButton, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE))
                                                .addGap(226))))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(17)
                                .addComponent(manageInformation, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(33)
                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addGap(34)
                                .addComponent(removeButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addGap(35)
                                .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(26))
        );
        mainPanel.setLayout(gl_mainPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAnimal().setVisible(true);
                dispose();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RemoveAnimal().setVisible(true);
                dispose();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateAnimal().setVisible(true);
                dispose();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                dispose();
            }
        });


    }


}
