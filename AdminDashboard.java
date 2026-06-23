package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame 
        implements ActionListener {


    JLabel title;


    JButton donorBtn,
            orgBtn,
            foodBtn,
            wasteBtn,
            analyticsBtn,
            notificationBtn,
            logoutBtn;



    public AdminDashboard() {


        setTitle("Admin Dashboard");


        setSize(500, 550);


        setLayout(null);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );



        title = new JLabel(
                "ADMIN DASHBOARD"
        );


        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );


        title.setBounds(
                120,
                30,
                250,
                30
        );


        add(title);



        donorBtn = new JButton(
                "View Donors"
        );


        donorBtn.setBounds(
                140,
                90,
                200,
                35
        );


        add(donorBtn);



        orgBtn = new JButton(
                "View Organizations"
        );


        orgBtn.setBounds(
                140,
                140,
                200,
                35
        );


        add(orgBtn);



        foodBtn = new JButton(
                "View Food Records"
        );


        foodBtn.setBounds(
                140,
                190,
                200,
                35
        );


        add(foodBtn);



        wasteBtn = new JButton(
                "View Waste Reports"
        );


        wasteBtn.setBounds(
                140,
                240,
                200,
                35
        );


        add(wasteBtn);



        analyticsBtn = new JButton(
                "System Analytics"
        );


        analyticsBtn.setBounds(
                140,
                290,
                200,
                35
        );


        add(analyticsBtn);



        notificationBtn = new JButton(
                "View Notifications"
        );


        notificationBtn.setBounds(
                140,
                340,
                200,
                35
        );


        add(notificationBtn);



        logoutBtn = new JButton(
                "Logout"
        );


        logoutBtn.setBounds(
                140,
                390,
                200,
                35
        );


        add(logoutBtn);



        // Button Events

        donorBtn.addActionListener(this);

        orgBtn.addActionListener(this);

        foodBtn.addActionListener(this);

        wasteBtn.addActionListener(this);

        analyticsBtn.addActionListener(this);

        notificationBtn.addActionListener(this);

        logoutBtn.addActionListener(this);



        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == donorBtn) {


        	new ViewDonors();

        }


        else if(e.getSource() == orgBtn) {


        	new ViewOrganization();

        }


        else if(e.getSource() == foodBtn) {

            new ViewFoodRecords();

        }


        else if(e.getSource() == wasteBtn) {

            new ViewWasteReports();

        }


        else if(e.getSource() == analyticsBtn) {


        	new AdminAnalytics();

        }


        else if(e.getSource() == notificationBtn) {


            // Admin ID temporary
            new ViewNotification(
                    "ADMIN",
                    1
            );

        }


        else if(e.getSource() == logoutBtn) {


            dispose();


            new MainPage();

        }

    }

}