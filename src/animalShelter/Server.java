package animalShelter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Server extends JFrame implements Runnable{

    private JPanel mainPanel;
    private JTextField serverChat;
    private JTextArea serverDisplay;
    private int clientNo = 0;
    private HashMap<Integer, Socket> clientMap;
    private ConcurrentHashMap<Integer, StringBuilder> chatRecords = new ConcurrentHashMap<>();
    private DefaultListModel<Integer> listModel = new DefaultListModel<Integer>();
    private JList<Integer> clientList;
    private Socket clientSocket;

    private BufferedReader fromClient;
    private PrintWriter toClient;
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

        //add JList to display connected clients
        if (clientMap != null) {
            for (Integer clientNum : clientMap.keySet()) {
                listModel.addElement(clientNum);
            }
        }
        clientList = new JList<Integer>(listModel);

        //add ListSelectionListener to JList, so that the server can select a client to chat with
        clientList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedClientNum = clientList.getSelectedValue();
                Socket selectedClientSocket = clientMap.get(selectedClientNum);
                StringBuilder selectedClientRecord = chatRecords.get(selectedClientNum);
                try {
                    fromClient = new BufferedReader(new InputStreamReader(selectedClientSocket.getInputStream()));
                    toClient = new PrintWriter(selectedClientSocket.getOutputStream(), true);
                    if (selectedClientRecord != null) {
                        serverDisplay.setText(selectedClientRecord.toString());
                    } else {
                        serverDisplay.setText("");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        JScrollPane listScrollPane = new JScrollPane();
        listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        listScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(15)
                                .addComponent(listScrollPane, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addGap(35)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(serverChat, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(send))
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
                                .addGap(26))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(listScrollPane, Alignment.LEADING)
                                        .addGroup(Alignment.LEADING, gl_mainPanel.createSequentialGroup()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(serverChat, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(send))))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        listScrollPane.setViewportView(clientList);
        serverDisplay = new JTextArea();
        serverDisplay.setLineWrap(true);
        serverDisplay.setEditable(false);
        scrollPane.setViewportView(serverDisplay);
        mainPanel.setLayout(gl_mainPanel);

        ActionListener sendAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer selectedClientNum = clientList.getSelectedValue();
                if (selectedClientNum == null ||selectedClientNum == -1) {
                    // no client selected, do nothing
                    return;
                }
                Socket selectedClientSocket = clientMap.get(selectedClientNum);
                if(!serverChat.getText().isEmpty()){
                    String serverMessage = serverChat.getText();
                    toClient.println(serverMessage);
                    serverChat.setText("");
                    synchronized (chatRecords) {
                        StringBuilder selectedClientRecord = chatRecords.get(selectedClientNum);
                        selectedClientRecord.append("You: " + serverMessage + '\n');
                        serverDisplay.setText(selectedClientRecord.toString());
                    }
                }
            }
        };
        send.addActionListener(sendAction);
        serverChat.addActionListener(sendAction);
    }

    public class HandleClient extends Thread{
        private Socket socket;
        private int clientNum;

        public HandleClient(Socket socket, int clientNum){
            this.socket = socket;
            this.clientNum = clientNum;
        }
        @Override
        public void run() {
            //initialize chat record for this client with name and connection message
            StringBuilder record = new StringBuilder();
            chatRecords.put(clientNum, record);
            record.append("One customer has connected. " + '\n');
            String clientName = null;
            try {
                clientName = fromClient.readLine();
                record.append("Customer name: " + clientName + '\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //keep reading message from client and setting chat record
            while(true) {
                try {
                    fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    //toClient = new PrintWriter(socket.getOutputStream(), true);
                    String clientMessage = fromClient.readLine();
                    if (clientMessage != null) {
                        // check if the message is "DISCONNECT"
                        if (clientMessage.equals("DISCONNECT")) {
                            clientMap.remove(clientNum);
                            listModel.removeElement(clientNum);
                            socket.close();
                            break;
                        }
                    }
                    synchronized (chatRecords) {
                        record = chatRecords.get(clientNum);
                        record.append("Customer " + clientNum + ": " + clientMessage).append("\n");
                    }
                    System.out.println("server: " + clientMessage);
                    serverDisplay.setText(record.toString());
                    //System.out.println(clientMessage);
                    //fromClient.close();
                    //toClient.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void run() {
        clientMap = new HashMap<>();
        try{
            ServerSocket ss = new ServerSocket(9898);
            serverDisplay.setText("Chat server started. " + '\n');
            while(true){
                clientSocket = ss.accept();
                fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                toClient = new PrintWriter(clientSocket.getOutputStream(), true);
                clientNo++;
                //add new client into the clientMap and JList
                clientMap.put(clientNo, clientSocket);
                listModel.addElement(clientNo);
                new Thread(new HandleClient(clientSocket, clientNo)).start();
//                HandleClient client = new HandleClient(clientSocket, clientNo);
//                client.start();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

