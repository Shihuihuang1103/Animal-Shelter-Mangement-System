package animalShelter;

import com.mysql.cj.protocol.Resultset;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main extends JFrame{
    private JDBC db = new JDBC();
    private Connection connection;
    public static ArrayList<Animal> animalList = new ArrayList<Animal>();

    public Main() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        setupPanels();
        setTitle("Welcome!");
        setBounds(100, 100, 800, 550);
        setVisible(true);
        fillAnimalList();
    }

    public void setupPanels()  {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(mainPanel);

        JLabel welcome = new JLabel("Lovely Paws Animal Shelter");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        try {
            BufferedImage img = ImageIO.read(new File("src/logo/loving paw.png"));
            welcome.setIcon(new ImageIcon(img));
        } catch (IOException e){
            e.getMessage();
        }
        //welcome.setIcon(new ImageIcon(Main.class.getResource("src/logo/loving paw.png")));
        welcome.setForeground(new Color(75, 161, 222));
        welcome.setFont(new Font("Lava Kannada", Font.PLAIN, 40));

        JButton login = new JButton("Admin Login");
        login.setHorizontalAlignment(SwingConstants.LEFT);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton appointment = new JButton("Make An Appointment");

        JButton adoption = new JButton("Start An Adoption");
        adoption.setHorizontalAlignment(SwingConstants.RIGHT);
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(welcome, GroupLayout.PREFERRED_SIZE, 766, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(126)
                                                .addComponent(login)
                                                .addGap(28)
                                                .addComponent(appointment)
                                                .addGap(36)
                                                .addComponent(adoption)))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addComponent(welcome, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(adoption)
                                        .addComponent(login)
                                        .addComponent(appointment))
                                .addContainerGap(372, Short.MAX_VALUE))
        );
        mainPanel.setLayout(gl_mainPanel);


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                dispose();
            }
        });

        appointment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Appointment().setVisible(true);
                dispose();
            }
        });

        adoption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Adopt().setVisible(true);
                dispose();
            }
        });

    }

    public void fillAnimalList() throws SQLException {
        try {
            connection = db.getCon();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        String sql = "SELECT * FROM animal";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Animal animal = new Animal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
            animalList.add(animal);
        }
    }

    public static void main(String[] args) throws SQLException {
        // Create a new instance of the LoginGUI class
        Main page = new Main();
    }
}




