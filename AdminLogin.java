package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import dao.AdminDAO;
import model.Admin;

public class AdminLogin extends JFrame implements ActionListener {

    JLabel title, userLabel, passLabel;

    JTextField userField;
    JPasswordField passField;

    JButton loginBtn, backBtn;


    public AdminLogin() {

        setTitle("Admin Login");

        setSize(400, 300);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        title = new JLabel("ADMIN LOGIN");

        title.setFont(new Font("Arial", Font.BOLD, 20));

        title.setBounds(120, 20, 200, 30);

        add(title);


        userLabel = new JLabel("Username:");

        userLabel.setBounds(50, 80, 100, 25);

        add(userLabel);


        userField = new JTextField();

        userField.setBounds(150, 80, 170, 25);

        add(userField);


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


            String username = userField.getText();

            String password =
                    String.valueOf(passField.getPassword());


            AdminDAO dao = new AdminDAO();


            Admin admin =
                    dao.loginAdmin(username, password);


            if(admin != null) {


                JOptionPane.showMessageDialog(
                    this,
                    "Welcome Admin"
                );


                dispose();


                new AdminDashboard();

            }

            else {


                JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password"
                );

            }

        }


        else if(e.getSource() == backBtn) {


            dispose();

        }

    }

}