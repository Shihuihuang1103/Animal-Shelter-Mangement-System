package animalShelter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Server extends JFrame implements Runnable{

    private JPanel mainPanel;
    private JTextField serverChat;
    private JTextArea serverDisplay;
    private static String chatRecord = "";

    private Socket socket;
    private DataInputStream fromClient;
    private DataOutputStream toClient;
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

        serverDisplay = new JTextArea();
        serverDisplay.setLineWrap(true);
        serverDisplay.setEditable(false);
        scrollPane.setViewportView(serverDisplay);
        mainPanel.setLayout(gl_mainPanel);

        ActionListener sendAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String serverMessage = serverChat.getText();
                    toClient.writeUTF(serverMessage);
                    chatRecord += "You: " + serverMessage + '\n';
                    serverDisplay.setText(chatRecord);
                    serverChat.setText("");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        send.addActionListener(sendAction);
        serverChat.addActionListener(sendAction);
    }

    public class handleClient extends Thread{
        private Socket socket;
        public handleClient(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run(){
            while(true){
                try{
                    String clientMessage = fromClient.readUTF();
                    chatRecord += "Customer: " + clientMessage + '\n';
                    serverDisplay.setText(chatRecord);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @Override
    public void run() {
        try{
            ServerSocket ss = new ServerSocket(9898);
            chatRecord += "Chat server started. " + '\n';
            serverDisplay.setText(chatRecord);
            while(true){
                socket = ss.accept();
                chatRecord += "One customer has connected. " + '\n';
                serverDisplay.setText(chatRecord);
                fromClient = new DataInputStream(socket.getInputStream());
                toClient = new DataOutputStream(socket.getOutputStream());
                String clientName = fromClient.readUTF();
                chatRecord += "Customer name: " + clientName + '\n';
                serverDisplay.setText(chatRecord);
                handleClient client = new handleClient(socket);
                client.start();
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }

}

