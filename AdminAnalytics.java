package ui;

import javax.swing.*;
import java.awt.*;

import dao.AdminDAO;

public class AdminAnalytics extends JFrame {


    public AdminAnalytics() {


        setTitle("System Analytics");


        setSize(500, 500);


        setLayout(new GridLayout(9, 1, 10, 10));


        setLocationRelativeTo(null);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        AdminDAO dao = new AdminDAO();


        JLabel title = new JLabel(
                "SYSTEM ANALYTICS",
                SwingConstants.CENTER
        );


        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );


        add(title);


        add(new JLabel(
                "Total Donors: " +
                dao.getTotalDonors()
        ));


        add(new JLabel(
                "Total Organizations: " +
                dao.getTotalOrganizations()
        ));


        add(new JLabel(
                "Total Food Donations: " +
                dao.getTotalFood()
        ));


        add(new JLabel(
                "Available Food: " +
                dao.getAvailableFood()
        ));


        add(new JLabel(
                "Collected Food: " +
                dao.getCollectedFood()
        ));


        add(new JLabel(
                "Distributed Food: " +
                dao.getDistributedFood()
        ));


        add(new JLabel(
                "Expired Food: " +
                dao.getExpiredFood()
        ));


        add(new JLabel(
                "Total Waste Records: " +
                dao.getTotalWaste()
        ));


        setVisible(true);

    }

}