package animalShelter;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Client extends JFrame implements Runnable{

    private JPanel mainPanel;
    private JTextField nameInput;
    private JTextField clientChat;
    private Socket socket = null;
    private JTextArea clientDisplay;
    private PrintWriter toServer;
    private BufferedReader fromServer;
    private String chatRecord = "";

    public Client() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        clientDisplay = new JTextArea();
        clientDisplay.setLineWrap(true);
        clientDisplay.setEditable(false);
        scrollPane.setViewportView(clientDisplay);
        mainPanel.setLayout(gl_mainPanel);


        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameInput.getText();
                if (name.length() > 0) {
                    chatRecord += "Welcome " + name + "!" + "\n" + "Our customer service will be ready to help you soon!"+"\n";
                    clientDisplay.setText(chatRecord);
                } else {
                    chatRecord += "Please enter your name!"+"\n";
                    clientDisplay.setText(chatRecord);
                }
                try{
                    socket = new Socket("localhost", 9898);
                    fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    toServer = new PrintWriter(socket.getOutputStream(), true);
                    toServer.println(name);
                } catch (Exception ex) {
                    System.out.println(ex);
                    chatRecord+= "Error connecting to server"+"\n";
                    clientDisplay.setText(chatRecord);
                }
            }
        });

        ActionListener sendAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!clientChat.getText().isEmpty() && clientChat.getText()!= " "){
                    String serverMessage = clientChat.getText();
                    toServer.println(serverMessage);
                    chatRecord += "You: " + serverMessage + "\n";
                    System.out.println("client: " + serverMessage);
                    clientDisplay.setText(chatRecord);
                    clientChat.setText("");
                }
            }
        };

        send.addActionListener(sendAction);
        clientChat.addActionListener(sendAction);
  }

    public static void main(String[] args){
        Client client = new Client();
        client.run();
    }

    @Override
    public void run() {
        while(true) {
            if (socket == null) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                continue;
            }
            while (true) {
                try {
                    String serverMessage = fromServer.readLine();
                    chatRecord += "LovelyPaws: " + serverMessage + "\n";
                    clientDisplay.setText(chatRecord);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}