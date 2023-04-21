package animalShelter;

import javax.swing.*;

public class Main extends JFrame{
    private JButton loginButton;
    private JButton adoptButton;
    private JButton appointmentButton;
    private JPanel mainPanel;
    public Main(){
        // Set the title of the window
        setTitle("Lovely Paw Animal Shelter");

        // Create a new button for logging in
        loginButton = new JButton("Admin Login");
        adoptButton = new JButton("Adopt A Pet");
        appointmentButton = new JButton("Make An Appointment");
        // Set the layout manager of the window to null
        setLayout(null);

        // Add the login button to the window
        loginButton.setBounds(600, 10, 150, 30); // Set the position and size of the button
        add(loginButton);

        adoptButton.setBounds(100, 500, 150, 30);
        add(adoptButton);

        appointmentButton.setBounds(500, 500, 180, 30);
        add(appointmentButton);
        // Set the size of the window
        setSize(800, 600);

        // Set the window to be visible
        setVisible(true);
    }
    public static void main(String[] args) {
        // Create a new instance of the LoginGUI class
        Main page = new Main();
    }
}




