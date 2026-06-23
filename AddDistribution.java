package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;

import model.Distribution;
import dao.DistributionDAO;


public class AddDistribution extends JFrame implements ActionListener {


    JLabel title;

    JLabel foodLabel,
            peopleLabel,
            quantityLabel,
            locationLabel,
            dateLabel;


    JTextField foodField,
            peopleField,
            quantityField,
            locationField,
            dateField;


    JButton distributeBtn,
            backBtn;


    public AddDistribution() {


        setTitle("Food Distribution");


        setSize(500, 500);


        setLayout(null);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        title = new JLabel("FOOD DISTRIBUTION");


        title.setFont(
                new Font("Arial", Font.BOLD, 20)
        );


        title.setBounds(120, 20, 250, 30);


        add(title);



        foodLabel = new JLabel("Food ID:");

        foodLabel.setBounds(50, 90, 150, 25);

        add(foodLabel);


        foodField = new JTextField();

        foodField.setBounds(200, 90, 200, 25);

        add(foodField);



        peopleLabel = new JLabel("People Served:");

        peopleLabel.setBounds(50, 140, 150, 25);

        add(peopleLabel);


        peopleField = new JTextField();

        peopleField.setBounds(200, 140, 200, 25);

        add(peopleField);



        quantityLabel = new JLabel("Quantity Distributed:");

        quantityLabel.setBounds(50, 190, 150, 25);

        add(quantityLabel);


        quantityField = new JTextField();

        quantityField.setBounds(200, 190, 200, 25);

        add(quantityField);



        locationLabel = new JLabel("Distribution Location:");

        locationLabel.setBounds(50, 240, 150, 25);

        add(locationLabel);


        locationField = new JTextField();

        locationField.setBounds(200, 240, 200, 25);

        add(locationField);



        dateLabel = new JLabel("Date & Time:");

        dateLabel.setBounds(50, 290, 150, 25);

        add(dateLabel);


        dateField = new JTextField();

        dateField.setBounds(200, 290, 200, 25);

        dateField.setText(
            "2026-06-19 12:00:00"
        );


        add(dateField);



        distributeBtn = new JButton(
                "Distribute Food"
        );


        distributeBtn.setBounds(
                70, 370, 150, 35
        );


        add(distributeBtn);



        backBtn = new JButton(
                "Back"
        );


        backBtn.setBounds(
                260, 370, 100, 35
        );


        add(backBtn);



        distributeBtn.addActionListener(this);

        backBtn.addActionListener(this);



        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == distributeBtn) {


            try {


                Distribution distribution =
                        new Distribution();


                distribution.setFoodId(
                    Integer.parseInt(
                        foodField.getText()
                    )
                );


                // Temporary Organization ID
                distribution.setOrganizationId(1);


                distribution.setPeopleServed(
                    Integer.parseInt(
                        peopleField.getText()
                    )
                );


                distribution.setQuantityDistributed(
                    Integer.parseInt(
                        quantityField.getText()
                    )
                );


                distribution.setLocation(
                    locationField.getText()
                );


                distribution.setDistributionDate(
                    Timestamp.valueOf(
                        dateField.getText()
                    )
                );


                DistributionDAO dao =
                        new DistributionDAO();


                boolean result =
                        dao.addDistribution(distribution);


                if(result) {


                    JOptionPane.showMessageDialog(
                            this,
                            "Food Distributed Successfully!"
                    );


                    dispose();


                    new AddDistribution();


                }
                else {


                    JOptionPane.showMessageDialog(
                            this,
                            "Distribution Failed!"
                    );

                }


            }
            catch(Exception ex) {


                JOptionPane.showMessageDialog(
                    this,
                    "Enter Valid Details!\nDate format: yyyy-mm-dd hh:mm:ss"
                );


            }

        }


        else if(e.getSource() == backBtn) {


            dispose();


        }

    }
}
    