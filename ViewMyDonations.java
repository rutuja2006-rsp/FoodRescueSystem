package ui;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

import dao.FoodDAO;

public class ViewMyDonations extends JFrame {

    JTable table;

    DefaultTableModel model;


    public ViewMyDonations() {

        setTitle("My Food Donations");

        setSize(800, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        model = new DefaultTableModel();
        
     // Table Columns
        model.addColumn("Food Name");
        model.addColumn("Category");
        model.addColumn("Quantity");
        model.addColumn("Unit");
        model.addColumn("Expiry Time");
        model.addColumn("Status");


        // Temporary donor ID
        int donorId = 1;


        FoodDAO dao = new FoodDAO();


        ResultSet rs = dao.getDonorFoods(donorId);


        try {

            while(rs.next()) {

                String foodName = rs.getString("food_name");

                String category = rs.getString("category");

                int quantity = rs.getInt("quantity");

                String unit = rs.getString("unit");

                String expiry = rs.getString("expiry_time");

                String status = rs.getString("status");


                model.addRow(new Object[] {

                    foodName,
                    category,
                    quantity,
                    unit,
                    expiry,
                    status

                });

            }

        }
        catch(Exception e) {

            e.printStackTrace();

        }


        table = new JTable(model);


        JScrollPane scroll =
                new JScrollPane(table);


        add(scroll);


        setVisible(true);

    }

}