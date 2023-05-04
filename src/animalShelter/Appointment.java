package animalShelter;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Appointment extends JFrame {
    private LocalDate currDate = LocalDate.now();
    private JDBC db = new JDBC();
    private Connection connection;
    private JLabel messageLabel;
    public Appointment() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(246, 246, 246));
        setBounds(100, 100, 600, 450);
        setupPanels();
    }


    public ArrayList<AvailableTimeSlot> AvailableTimeSlotList () throws Exception {
        ArrayList<AvailableTimeSlot> AvailableTimeSlotList = new ArrayList<>();
        connection = db.getCon();
        String sql = "SELECT * FROM appointment WHERE date = ? AND time = ?";
        PreparedStatement pst = connection.prepareStatement(sql);

        for(int i = 1; i <= 14; i++){
            LocalDate date = currDate.plusDays(i);
            Date sqlDate = Date.valueOf(date);
            pst.setDate(1, sqlDate);
            pst.setString(2, "AM");
            //if there is result in db, then the date and time is not available
            ResultSet rs = pst.executeQuery();
            if(!rs.next()){
                AvailableTimeSlotList.add(new AvailableTimeSlot(date, "AM"));
            }
            pst.setDate(1,sqlDate);
            pst.setString(2, "PM");
            rs = pst.executeQuery();
            if(!rs.next()){
                AvailableTimeSlotList.add(new AvailableTimeSlot(date, "PM"));
            }
        }
        return AvailableTimeSlotList;
    }


    public void setupPanels() {

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(mainPanel);

        JLabel appointment = new JLabel("Make An Appointment");
        appointment.setForeground(new Color(41, 104, 205));
        appointment.setFont(new Font("Lava Kannada", Font.PLAIN, 40));

        JButton home = new JButton("Homepage");

        JLabel firstname = new JLabel("Firstname: ");
        firstname.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField fnameInput = new JTextField();
        firstname.setLabelFor(fnameInput);
        fnameInput.setColumns(10);

        JLabel lastname = new JLabel("Lastname:");
        lastname.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField lnameInput = new JTextField();
        lastname.setLabelFor(lnameInput);
        lnameInput.setColumns(10);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField emailInput = new JTextField();
        email.setLabelFor(emailInput);
        emailInput.setColumns(10);

        JLabel dateTime = new JLabel("Please pick an available time:");
        dateTime.setFont(new Font("Lava Kannada", Font.PLAIN, 15));


        JComboBox<AvailableTimeSlot> timeSelect = new JComboBox<>();
        try {
            ArrayList<AvailableTimeSlot> timeSlotArrayList = AvailableTimeSlotList();
            for(int i = 0; i < timeSlotArrayList.size(); i++){
                timeSelect.addItem(timeSlotArrayList.get(i));
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        JButton submit = new JButton("Submit");

        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("Lava Kannada", Font.PLAIN, 13));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(106)
                                                .addComponent(appointment))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(90)
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                                                                        .addComponent(dateTime, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(firstname, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                                                                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(lastname, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))))
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
                                                                        .addComponent(timeSelect, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(fnameInput, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                                                        .addComponent(lnameInput)
                                                                        .addComponent(emailInput))))))
                                .addContainerGap(80, Short.MAX_VALUE))
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addContainerGap(242, Short.MAX_VALUE)
                                .addComponent(submit, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                .addGap(237))
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addContainerGap(242, Short.MAX_VALUE)
                                .addComponent(home)
                                .addGap(237))
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addComponent(appointment)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(home)
                                .addGap(18)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(firstname)
                                        .addComponent(fnameInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lastname, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lnameInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(dateTime, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timeSelect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(17)
                                .addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(submit)
                                .addContainerGap(43, Short.MAX_VALUE))
        );
        mainPanel.setLayout(gl_mainPanel);

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Main().setVisible(true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkAvailability = "SELECT * FROM appointment WHERE date = ? AND time = ?";
                String sql = "INSERT INTO `appointment` (`email`, `fname`, `lname`, `date`, `time`) VALUES (?, ?, ?, ?, ?)";
                String emailStr = emailInput.getText();
                String fnameStr = fnameInput.getText();
                String lnameStr = lnameInput.getText();
                AvailableTimeSlot selectedTime = (AvailableTimeSlot) timeSelect.getSelectedItem();
                LocalDate date = selectedTime.getDate();
                Date sqlDate = Date.valueOf(date);
                String time = selectedTime.getTime();
                try {
                    connection = db.getCon();
                    PreparedStatement pst1 = connection.prepareStatement(checkAvailability);
                    pst1.setDate(1, sqlDate);
                    pst1.setString(2, time);
                    PreparedStatement pst2 = connection.prepareStatement(sql);
                    pst2.setString(1, emailStr);
                    pst2.setString(2, fnameStr);
                    pst2.setString(3, lnameStr);
                    pst2.setDate(4, sqlDate);
                    pst2.setString(5, time);
                    ResultSet rs = pst1.executeQuery();
                    if(!rs.next()){
                        int rowsAffected = pst2.executeUpdate();
                        if(rowsAffected > 0){
                            messageLabel.setForeground(new Color(51, 176, 63));
                            messageLabel.setText("Your appointment is booked successfully!");
                            emailInput.setText("");
                            fnameInput.setText("");
                            lnameInput.setText("");
                        } else {
                            messageLabel.setForeground(Color.RED);
                            messageLabel.setText("Something went wrong!");
                        }
                    } else {
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("The time you selected is no longer available!");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}

