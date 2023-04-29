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

public class DeleteConfirm extends JFrame{
    public DeleteConfirm(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupPanels();
        setBounds(100, 100, 380, 180);
        setVisible(true);
    }

    public void setupPanels(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(mainPanel);

        JLabel confirm = new JLabel("Are you sure you want to delete this animal?");
        confirm.setForeground(Color.RED);
        confirm.setFont(new Font("Lava Kannada", Font.PLAIN, 14));

        JButton yes = new JButton("Yes");

        JButton cancel = new JButton("Cancel");
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(27)
                                                .addComponent(confirm))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(115)
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(yes))))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(32)
                                .addComponent(confirm)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(yes)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(cancel)
                                .addGap(8))
        );
        mainPanel.setLayout(gl_mainPanel);

        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public static void main(String[] args)  {
        new DeleteConfirm();
    }
}
