package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;

import model.Waste;
import dao.WasteDAO;


public class AddWaste extends JFrame implements ActionListener {


    JLabel title;

    JLabel foodLabel,
            quantityLabel,
            reasonLabel,
            dateLabel;


    JTextField foodField,
            quantityField,
            dateField;


    JTextArea reasonArea;


    JButton submitBtn,
            backBtn;


    public AddWaste() {


        setTitle("Waste Management");


        setSize(500, 500);


        setLayout(null);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        title = new JLabel("FOOD WASTE DETAILS");


        title.setFont(
                new Font("Arial", Font.BOLD, 20)
        );


        title.setBounds(110, 20, 300, 30);


        add(title);



        foodLabel = new JLabel("Food ID:");

        foodLabel.setBounds(50, 90, 150, 25);

        add(foodLabel);


        foodField = new JTextField();

        foodField.setBounds(200, 90, 200, 25);

        add(foodField);



        quantityLabel = new JLabel("Quantity Wasted:");

        quantityLabel.setBounds(50, 140, 150, 25);

        add(quantityLabel);


        quantityField = new JTextField();

        quantityField.setBounds(200, 140, 200, 25);

        add(quantityField);



        reasonLabel = new JLabel("Waste Reason:");

        reasonLabel.setBounds(50, 190, 150, 25);

        add(reasonLabel);


        reasonArea = new JTextArea();

        JScrollPane scroll =
                new JScrollPane(reasonArea);


        scroll.setBounds(200, 190, 200, 80);

        add(scroll);



        dateLabel = new JLabel("Date & Time:");

        dateLabel.setBounds(50, 300, 150, 25);

        add(dateLabel);


        dateField = new JTextField();

        dateField.setBounds(200, 300, 200, 25);


        dateField.setText(
                "2026-06-19 12:00:00"
        );


        add(dateField);



        submitBtn =
                new JButton("Add Waste");


        submitBtn.setBounds(
                70, 380, 130, 35
        );


        add(submitBtn);



        backBtn =
                new JButton("Back");


        backBtn.setBounds(
                250, 380, 100, 35
        );


        add(backBtn);



        submitBtn.addActionListener(this);

        backBtn.addActionListener(this);



        setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submitBtn) {

            try {

                Waste waste = new Waste();


                waste.setFoodId(
                    Integer.parseInt(
                        foodField.getText()
                    )
                );


                waste.setQuantityWasted(
                    Integer.parseInt(
                        quantityField.getText()
                    )
                );


                waste.setReason(
                    reasonArea.getText()
                );


                waste.setWasteDate(
                    Timestamp.valueOf(
                        dateField.getText()
                    )
                );


                WasteDAO dao = new WasteDAO();


                boolean result =
                        dao.addWaste(waste);


                if(result) {


                    JOptionPane.showMessageDialog(
                        this,
                        "Waste Added Successfully!"
                    );


                    dispose();


                    new AddWaste();


                }
                else {


                    JOptionPane.showMessageDialog(
                        this,
                        "Failed to Add Waste!"
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