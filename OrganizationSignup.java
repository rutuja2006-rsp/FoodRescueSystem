package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import dao.OrganizationDAO;
import model.Organization;

public class OrganizationSignup extends JFrame implements ActionListener {

    JLabel title, nameLabel, emailLabel, phoneLabel,
           addressLabel, cityLabel, pinLabel, passLabel;

    JTextField nameField, emailField, phoneField,
               addressField, cityField, pinField;

    JPasswordField passField;

    JButton registerBtn, backBtn;


    public OrganizationSignup() {

        setTitle("Organization Registration");
        setSize(500, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        title = new JLabel("ORGANIZATION SIGN UP");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(100, 20, 300, 30);
        add(title);


        nameLabel = new JLabel("Organization Name:");
        nameLabel.setBounds(40, 80, 150, 25);
        add(nameLabel);


        nameField = new JTextField();
        nameField.setBounds(200, 80, 200, 25);
        add(nameField);


        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(40, 130, 150, 25);
        add(emailLabel);


        emailField = new JTextField();
        emailField.setBounds(200, 130, 200, 25);
        add(emailField);


        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(40, 180, 150, 25);
        add(phoneLabel);


        phoneField = new JTextField();
        phoneField.setBounds(200, 180, 200, 25);
        add(phoneField);


        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(40, 230, 150, 25);
        add(addressLabel);


        addressField = new JTextField();
        addressField.setBounds(200, 230, 200, 25);
        add(addressField);


        cityLabel = new JLabel("City:");
        cityLabel.setBounds(40, 280, 150, 25);
        add(cityLabel);


        cityField = new JTextField();
        cityField.setBounds(200, 280, 200, 25);
        add(cityField);


        pinLabel = new JLabel("Pincode:");
        pinLabel.setBounds(40, 330, 150, 25);
        add(pinLabel);


        pinField = new JTextField();
        pinField.setBounds(200, 330, 200, 25);
        add(pinField);


        passLabel = new JLabel("Password:");
        passLabel.setBounds(40, 380, 150, 25);
        add(passLabel);


        passField = new JPasswordField();
        passField.setBounds(200, 380, 200, 25);
        add(passField);


        registerBtn = new JButton("Register");
        registerBtn.setBounds(80, 460, 120, 35);
        add(registerBtn);


        backBtn = new JButton("Back");
        backBtn.setBounds(250, 460, 120, 35);
        add(backBtn);


        registerBtn.addActionListener(this);
        backBtn.addActionListener(this);


        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == registerBtn) {


            Organization org = new Organization();

            org.setOrgName(nameField.getText());
            org.setEmail(emailField.getText());
            org.setPhone(phoneField.getText());
            org.setAddress(addressField.getText());
            org.setCity(cityField.getText());
            org.setPincode(pinField.getText());
            org.setPassword(String.valueOf(passField.getPassword()));


            OrganizationDAO dao = new OrganizationDAO();


            boolean result = dao.registerOrganization(org);


            if(result) {


                JOptionPane.showMessageDialog(
                    this,
                    "Organization Registered Successfully!"
                );


                dispose();

            }
            else {


                JOptionPane.showMessageDialog(
                    this,
                    "Email already exists or Registration Failed!"
                );

            }

        }


        else if(e.getSource() == backBtn) {


            dispose();

        }

    }

}