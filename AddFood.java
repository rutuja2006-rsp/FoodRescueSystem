package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;

import dao.FoodDAO;
import model.Food;

public class AddFood extends JFrame implements ActionListener {

    JLabel title, nameLabel, categoryLabel, typeLabel,
            quantityLabel, unitLabel, prepLabel,
            expiryLabel, addressLabel, cityLabel,
            pinLabel;

    JTextField nameField, categoryField, quantityField,
            unitField, prepField, expiryField,
            addressField, cityField, pinField;

    JComboBox<String> typeBox;

    JButton addBtn, backBtn;


    public AddFood() {

        setTitle("Add Food Donation");

        setSize(550, 650);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        title = new JLabel("ADD FOOD DONATION");

        title.setFont(new Font("Arial", Font.BOLD, 22));

        title.setBounds(120, 20, 300, 30);

        add(title);


        nameLabel = new JLabel("Food Name:");
        nameLabel.setBounds(50, 80, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 80, 250, 25);
        add(nameField);


        categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(50, 120, 120, 25);
        add(categoryLabel);

        categoryField = new JTextField();
        categoryField.setBounds(180, 120, 250, 25);
        add(categoryField);


        typeLabel = new JLabel("Food Type:");
        typeLabel.setBounds(50, 160, 120, 25);
        add(typeLabel);

        typeBox = new JComboBox<>(
            new String[]{"Veg", "Non-Veg"}
        );

        typeBox.setBounds(180, 160, 250, 25);

        add(typeBox);
        
        quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(50, 200, 120, 25);
        add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(180, 200, 250, 25);
        add(quantityField);


        unitLabel = new JLabel("Unit:");
        unitLabel.setBounds(50, 240, 120, 25);
        add(unitLabel);

        unitField = new JTextField();
        unitField.setBounds(180, 240, 250, 25);
        add(unitField);


        prepLabel = new JLabel("Preparation Time:");
        prepLabel.setBounds(50, 280, 120, 25);
        add(prepLabel);

        prepField = new JTextField();
        prepField.setBounds(180, 280, 250, 25);
        add(prepField);


        expiryLabel = new JLabel("Expiry Time:");
        expiryLabel.setBounds(50, 320, 120, 25);
        add(expiryLabel);

        expiryField = new JTextField();
        expiryField.setBounds(180, 320, 250, 25);
        add(expiryField);


        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 360, 120, 25);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(180, 360, 250, 25);
        add(addressField);


        cityLabel = new JLabel("City:");
        cityLabel.setBounds(50, 400, 120, 25);
        add(cityLabel);

        cityField = new JTextField();
        cityField.setBounds(180, 400, 250, 25);
        add(cityField);


        pinLabel = new JLabel("Pincode:");
        pinLabel.setBounds(50, 440, 120, 25);
        add(pinLabel);

        pinField = new JTextField();
        pinField.setBounds(180, 440, 250, 25);
        add(pinField);


        addBtn = new JButton("Add Food");
        addBtn.setBounds(90, 520, 140, 35);
        add(addBtn);


        backBtn = new JButton("Back");
        backBtn.setBounds(280, 520, 140, 35);
        add(backBtn);


        addBtn.addActionListener(this);
        backBtn.addActionListener(this);


        setVisible(true);
        
    }
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == addBtn) {

                try {

                    Food food = new Food();

                    // Temporary donor ID (baad mein login wale donor ki ID aayegi)
                    food.setDonorId(1);

                    food.setFoodName(nameField.getText());

                    food.setCategory(categoryField.getText());

                    food.setFoodType(
                            typeBox.getSelectedItem().toString()
                    );

                    food.setQuantity(
                            Integer.parseInt(quantityField.getText())
                    );

                    food.setUnit(unitField.getText());


                    // Format:
                    // 2026-06-18 14:30:00

                    food.setPreparationTime(
                            Timestamp.valueOf(
                                    prepField.getText()
                            )
                    );


                    food.setExpiryTime(
                            Timestamp.valueOf(
                                    expiryField.getText()
                            )
                    );


                    food.setAddress(addressField.getText());

                    food.setCity(cityField.getText());

                    food.setPincode(pinField.getText());


                    FoodDAO dao = new FoodDAO();


                    boolean result = dao.addFood(food);


                    if(result) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Food Added Successfully!"
                        );


                        dispose();

                    }
                    else {

                        JOptionPane.showMessageDialog(
                                this,
                                "Failed to Add Food!"
                        );
                    }

                }
                catch(Exception ex) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Data! Check quantity and date format."
                    );

                }

            }


            else if(e.getSource() == backBtn) {

                dispose();

            }

        }
    }
    
        