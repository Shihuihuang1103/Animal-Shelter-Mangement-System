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
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Appointment extends JFrame {
    private LocalDate currDate = LocalDate.now();
    private JDBC db = new JDBC();
    private Connection connection;

    public Appointment() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(246, 246, 246));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 550);
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

    public void setupPanels()  {

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

        JLabel date = new JLabel("Date: \n(YYYY-MM-DD)");
        date.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JTextField dateInput = new JTextField();
        date.setLabelFor(dateInput);
        dateInput.setColumns(10);

        JLabel time = new JLabel("Time: ");
        time.setFont(new Font("Lava Kannada", Font.PLAIN, 15));

        JComboBox timeSelect = new JComboBox();
        timeSelect.setModel(new DefaultComboBoxModel(new String[] {"A.M. (9:00 - 11:00)", "P.M. (1:00 - 3:00)"}));

        JButton submit = new JButton("Submit");

        JLabel messageLabel = new JLabel("");
        messageLabel.setFont(new Font("Lava Kannada", Font.PLAIN, 13));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(337)
                                                .addComponent(home))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(188)
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                                                                        .addComponent(firstname, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lastname, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(date)
                                                                        .addComponent(time, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
                                                                        .addComponent(lnameInput, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                                        .addComponent(dateInput, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                                        .addComponent(fnameInput, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                                        .addComponent(emailInput, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                                        .addComponent(timeSelect, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addComponent(appointment)
                                                        .addComponent(messageLabel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(198, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
                                .addContainerGap(341, Short.MAX_VALUE)
                                .addComponent(submit, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                .addGap(338))
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
                                .addGap(9)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lastname, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lnameInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(date, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateInput, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(time, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timeSelect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(submit)
                                .addContainerGap(93, Short.MAX_VALUE))
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

            }
        });
    }
}

