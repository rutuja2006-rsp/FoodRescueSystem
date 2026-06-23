package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import dao.DonorDAO;
import model.Donor;

public class DonorLogin extends JFrame implements ActionListener {

    JLabel title, emailLabel, passLabel;

    JTextField emailField;
    JPasswordField passField;

    JButton loginBtn, backBtn;


    public DonorLogin() {

        setTitle("Donor Login");

        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        title = new JLabel("DONOR LOGIN");

        title.setFont(new Font("Arial", Font.BOLD, 20));

        title.setBounds(120, 20, 200, 30);

        add(title);


        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 80, 100, 25);
        add(emailLabel);


        emailField = new JTextField();
        emailField.setBounds(150, 80, 170, 25);
        add(emailField);


        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 130, 100, 25);
        add(passLabel);


        passField = new JPasswordField();
        passField.setBounds(150, 130, 170, 25);
        add(passField);


        loginBtn = new JButton("Login");
        loginBtn.setBounds(70, 190, 100, 30);
        add(loginBtn);


        backBtn = new JButton("Back");
        backBtn.setBounds(200, 190, 100, 30);
        add(backBtn);


        loginBtn.addActionListener(this);
        backBtn.addActionListener(this);


        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == loginBtn) {


            String email = emailField.getText();

            String password =
                    String.valueOf(passField.getPassword());


            DonorDAO dao = new DonorDAO();


            Donor donor =
                    dao.loginDonor(email, password);


            if(donor != null) {


                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful! Welcome " +
                        donor.getName()
                );


                dispose();


                new DonorDashboard();


            }
            else {


                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Email or Password"
                );

            }

        }


        else if(e.getSource() == backBtn) {


            dispose();

        }

    }
}