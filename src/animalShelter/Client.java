package animalShelter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Client extends JFrame {

    private JPanel mainPanel;
    private JTextField nameInput;
    private JTextField clientChat;

    public Client() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome!");
        setBounds(100, 100, 480, 350);
        setupPanels();
        setVisible(true);
    }
    public void setupPanels() {
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(246, 246, 246));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(mainPanel);

        nameInput = new JTextField();
        nameInput.setColumns(10);

        JLabel name = new JLabel("Please enter your name:");
        name.setLabelFor(nameInput);
        name.setFont(new Font("Lava Kannada", Font.PLAIN, 13));

        JButton connect = new JButton("Connect");

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        clientChat = new JTextField();
        clientChat.setColumns(10);

        JButton send = new JButton("Send");
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(14)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addComponent(clientChat, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(send)
                                                .addContainerGap())
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(name, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(nameInput, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                                                .addGap(18)
                                                                .addComponent(connect)))
                                                .addGap(29))))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(nameInput, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(name)
                                        .addComponent(connect))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(clientChat, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(send))
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        JTextArea clientDisplay = new JTextArea();
        clientDisplay.setLineWrap(true);
        scrollPane.setViewportView(clientDisplay);
        mainPanel.setLayout(gl_mainPanel);
    }

    public static void main(String[] args){
        new Client();
    }
}