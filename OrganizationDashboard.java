package ui;

import javax.swing.*;
import ui.AddDistribution;
import java.awt.*;
import java.awt.event.*;

public class OrganizationDashboard extends JFrame implements ActionListener {

    JLabel title;

    JButton viewFoodBtn;
    JButton requestBtn;
    JButton collectBtn;
    JButton distributeBtn;
    JButton logoutBtn;


    public OrganizationDashboard() {

        setTitle("Organization Dashboard");

        setSize(550, 450);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        title = new JLabel("ORGANIZATION DASHBOARD");

        title.setFont(new Font("Arial", Font.BOLD, 20));

        title.setBounds(100, 30, 350, 30);

        add(title);


        viewFoodBtn = new JButton("View Available Food");
        viewFoodBtn.setBounds(150, 90, 220, 35);
        add(viewFoodBtn);


        requestBtn = new JButton("My Collection Requests");
        requestBtn.setBounds(150, 145, 220, 35);
        add(requestBtn);


        collectBtn = new JButton("Mark Food Collected");
        collectBtn.setBounds(150, 200, 220, 35);
        add(collectBtn);


        distributeBtn = new JButton("Add Distribution Details");
        distributeBtn.setBounds(150, 255, 220, 35);
        add(distributeBtn);


        logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(150, 310, 220, 35);
        add(logoutBtn);


        viewFoodBtn.addActionListener(this);
        requestBtn.addActionListener(this);
        collectBtn.addActionListener(this);
        distributeBtn.addActionListener(this);
        logoutBtn.addActionListener(this);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == viewFoodBtn) {


            new AvailableFood();


        }


        else if(e.getSource() == requestBtn) {


        	new MyCollectionRequests();


        }


        else if(e.getSource() == collectBtn) {


        	new MarkCollect();

        }


        else if(e.getSource() == distributeBtn) {

        	new AddDistribution();

        }


        else if(e.getSource() == logoutBtn) {


            dispose();


        }

    }

}