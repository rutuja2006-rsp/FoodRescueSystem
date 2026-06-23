package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import model.Donor;
import dao.DonorDAO;

public class DonorSignup extends JFrame implements ActionListener {

    JLabel title, nameLabel, emailLabel, phoneLabel,
            addressLabel, cityLabel, pinLabel, passLabel;

    JTextField nameField, emailField, phoneField,
               addressField, cityField, pinField;

    JPasswordField passField;

    JButton registerBtn, backBtn;


    public DonorSignup() {

        setTitle("Donor Registration");

        setSize(500, 600);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        title = new JLabel("DONOR SIGN UP");

        title.setFont(new Font("Arial", Font.BOLD, 22));

        title.setBounds(140, 20, 250, 30);

        add(title);


        // Name

        nameLabel = new JLabel("Name:");

        nameLabel.setBounds(50, 80, 100, 25);

        add(nameLabel);


        nameField = new JTextField();

        nameField.setBounds(170, 80, 200, 25);

        add(nameField);


        // Email

        emailLabel = new JLabel("Email:");

        emailLabel.setBounds(50, 130, 100, 25);

        add(emailLabel);


        emailField = new JTextField();

        emailField.setBounds(170, 130, 200, 25);

        add(emailField);


        // Phone

        phoneLabel = new JLabel("Phone:");

        phoneLabel.setBounds(50, 180, 100, 25);

        add(phoneLabel);


        phoneField = new JTextField();

        phoneField.setBounds(170, 180, 200, 25);

        add(phoneField);


        // Address

        addressLabel = new JLabel("Address:");

        addressLabel.setBounds(50, 230, 100, 25);

        add(addressLabel);


        addressField = new JTextField();

        addressField.setBounds(170, 230, 200, 25);

        add(addressField);


        // City

        cityLabel = new JLabel("City:");

        cityLabel.setBounds(50, 280, 100, 25);

        add(cityLabel);


        cityField = new JTextField();

        cityField.setBounds(170, 280, 200, 25);

        add(cityField);


        // Pincode

        pinLabel = new JLabel("Pincode:");

        pinLabel.setBounds(50, 330, 100, 25);

        add(pinLabel);


        pinField = new JTextField();

        pinField.setBounds(170, 330, 200, 25);

        add(pinField);


        // Password

        passLabel = new JLabel("Password:");

        passLabel.setBounds(50, 380, 100, 25);

        add(passLabel);


        passField = new JPasswordField();

        passField.setBounds(170, 380, 200, 25);

        add(passField);


        // Register Button

        registerBtn = new JButton("Register");

        registerBtn.setBounds(90, 460, 120, 35);

        add(registerBtn);


        // Back Button

        backBtn = new JButton("Back");

        backBtn.setBounds(250, 460, 120, 35);

        add(backBtn);


        registerBtn.addActionListener(this);

        backBtn.addActionListener(this);


        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == registerBtn) {


            Donor donor = new Donor();


            donor.setName(nameField.getText());

            donor.setEmail(emailField.getText());

            donor.setPhone(phoneField.getText());

            donor.setAddress(addressField.getText());

            donor.setCity(cityField.getText());

            donor.setPincode(pinField.getText());

            donor.setPassword(
                    String.valueOf(passField.getPassword())
            );


            DonorDAO dao = new DonorDAO();


            boolean result =
                    dao.registerDonor(donor);



            if(result) {

                JOptionPane.showMessageDialog(
                        this,
                        "Registration Successful!"
                );

                dispose();

            }

            else {

                JOptionPane.showMessageDialog(
                        this,
                        "Email already exists or Registration failed!"
                );

            }

        }



        else if(e.getSource() == backBtn) {


            dispose();

        }

    }

}