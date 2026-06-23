package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPage extends JFrame implements ActionListener {

    JLabel title;

    JButton donorLogin;
    JButton donorSignup;

    JButton orgLogin;
    JButton orgSignup;

    JButton adminLogin;

    JButton exit;


    public MainPage() {

        setTitle("Food Rescue Management System");

        setSize(600, 500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);


        title = new JLabel("FOOD RESCUE MANAGEMENT SYSTEM");

        title.setFont(new Font("Arial", Font.BOLD, 20));

        title.setBounds(90, 40, 450, 30);

        add(title);


        donorLogin = new JButton("Donor Login");

        donorLogin.setBounds(200, 100, 180, 35);

        add(donorLogin);


        donorSignup = new JButton("Donor Sign Up");

        donorSignup.setBounds(200, 150, 180, 35);

        add(donorSignup);


        orgLogin = new JButton("Organization Login");

        orgLogin.setBounds(200, 200, 180, 35);

        add(orgLogin);


        orgSignup = new JButton("Organization Sign Up");

        orgSignup.setBounds(200, 250, 180, 35);

        add(orgSignup);


        adminLogin = new JButton("Admin Login");

        adminLogin.setBounds(200, 300, 180, 35);

        add(adminLogin);


        exit = new JButton("Exit");

        exit.setBounds(200, 350, 180, 35);

        add(exit);


        // Button Actions

        donorLogin.addActionListener(this);

        donorSignup.addActionListener(this);

        orgLogin.addActionListener(this);

        orgSignup.addActionListener(this);

        adminLogin.addActionListener(this);

        exit.addActionListener(this);


        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == donorLogin) {

        	new DonorLogin();
        }


        else if(e.getSource() == donorSignup) {

        	new DonorSignup();

        }


        else if(e.getSource() == orgLogin) {

        	new OrganizationLogin();

        }


        else if(e.getSource() == orgSignup) {


        	new OrganizationSignup();
        }


        else if(e.getSource() == adminLogin) {


        	new AdminLogin();

        }


        else if(e.getSource() == exit) {


            System.exit(0);

        }

    }

}