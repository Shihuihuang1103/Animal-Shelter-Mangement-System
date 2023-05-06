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
import javax.swing.LayoutStyle.ComponentPlacement;

public class Server extends JFrame{

    private JPanel mainPanel;
    private JTextField serverChat;
  public Server(){

      setTitle("Lovely Paws Customer Service");
      setBounds(100, 100, 480, 350);
      setupPanels();
      setVisible(true);
  }

    public void setupPanels(){
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(246, 246, 246));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(mainPanel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        serverChat = new JTextField();
        serverChat.setColumns(10);

        JButton send = new JButton("Send");
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(serverChat, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(send))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(14)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(serverChat, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(send))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        JTextArea serverDisplay = new JTextArea();
        serverDisplay.setLineWrap(true);
        scrollPane.setViewportView(serverDisplay);
        mainPanel.setLayout(gl_mainPanel);
    }
}

