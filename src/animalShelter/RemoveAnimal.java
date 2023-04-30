package animalShelter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RemoveAnimal extends JFrame {
    public JLabel messageLabel;
    public RemoveAnimal ra = this;

    public RemoveAnimal() {
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

        JLabel search = new JLabel("Search by Pet ID:");
        search.setHorizontalAlignment(SwingConstants.CENTER);
        search.setFont(new Font("Lava Kannada", Font.PLAIN, 20));

        JLabel remove = new JLabel("Remove Existing Animal");
        remove.setForeground(new Color(141, 94, 23));
        remove.setFont(new Font("Lava Kannada", Font.PLAIN, 40));
        remove.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField petidInput = new JTextField();
        petidInput.setHorizontalAlignment(SwingConstants.CENTER);
        petidInput.setColumns(10);

        JButton delete = new JButton("Delete");

        JButton back = new JButton("Go Back");

        messageLabel = new JLabel("");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);


        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addContainerGap(186, Short.MAX_VALUE)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                                .addComponent(remove)
                                                .addGap(166))
                                        .addGroup(Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                                .addComponent(petidInput, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                                .addGap(314))
                                        .addGroup(Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                                .addComponent(search, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                                .addGap(296))
                                        .addGroup(Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(delete)
                                                        .addComponent(back, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                                                .addGap(349))))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(28)
                                .addComponent(remove)
                                .addGap(45)
                                .addComponent(search)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(petidInput, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(32)
                                .addComponent(delete)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(back)
                                .addContainerGap(187, Short.MAX_VALUE))
        );
        mainPanel.setLayout(gl_mainPanel);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminPage().setVisible(true);
                dispose();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteConfirm(Integer.parseInt(petidInput.getText()), ra).setVisible(true);
                petidInput.setText("");
            }
        });
    }

    public static void main(String[] args)  {
        new RemoveAnimal();
    }
}
