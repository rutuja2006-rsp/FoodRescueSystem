package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DonorDashboard extends JFrame implements ActionListener {

    JLabel title;

    JButton addFoodBtn;
    JButton viewFoodBtn;
    JButton requestBtn;
    JButton feedbackBtn;
    JButton logoutBtn;


    public DonorDashboard() {

        setTitle("Donor Dashboard");

        setSize(500, 450);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        title = new JLabel("DONOR DASHBOARD");

        title.setFont(new Font("Arial", Font.BOLD, 22));

        title.setBounds(120, 30, 300, 30);

        add(title);


        addFoodBtn = new JButton("Add Food Donation");

        addFoodBtn.setBounds(150, 90, 200, 35);

        add(addFoodBtn);


        viewFoodBtn = new JButton("View My Donations");

        viewFoodBtn.setBounds(150, 145, 200, 35);

        add(viewFoodBtn);


        requestBtn = new JButton("View Requests");

        requestBtn.setBounds(150, 200, 200, 35);

        add(requestBtn);


        feedbackBtn = new JButton("View Feedback");

        feedbackBtn.setBounds(150, 255, 200, 35);

        add(feedbackBtn);


        logoutBtn = new JButton("Logout");

        logoutBtn.setBounds(150, 310, 200, 35);

        add(logoutBtn);


        addFoodBtn.addActionListener(this);

        viewFoodBtn.addActionListener(this);

        requestBtn.addActionListener(this);

        feedbackBtn.addActionListener(this);

        logoutBtn.addActionListener(this);


        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == addFoodBtn) {


            new AddFood();


        }


        else if(e.getSource() == viewFoodBtn) {


        	new ViewMyDonations();


        }


        else if(e.getSource() == requestBtn) {


        	new ViewRequests();

        }


        else if(e.getSource() == feedbackBtn) {


            JOptionPane.showMessageDialog(
                    this,
                    "Feedback Page"
            );


        }


        else if(e.getSource() == logoutBtn) {


            dispose();


        }

    }

}