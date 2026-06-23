package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

import dao.FoodDAO;

public class ViewFoodRecords extends JFrame {


    JTable table;

    DefaultTableModel model;


    public ViewFoodRecords() {


        setTitle("All Food Records");


        setSize(1000, 500);


        setLayout(new BorderLayout());


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );


        model = new DefaultTableModel();


        model.addColumn("Food ID");

        model.addColumn("Food Name");

        model.addColumn("Category");

        model.addColumn("Type");

        model.addColumn("Quantity");

        model.addColumn("City");

        model.addColumn("Status");

        model.addColumn("Expiry Time");


        FoodDAO dao =
                new FoodDAO();


        ResultSet rs =
                dao.getAllFood();


        try {


            while(rs.next()) {


                model.addRow(
                    new Object[] {


                        rs.getInt("food_id"),


                        rs.getString("food_name"),


                        rs.getString("category"),


                        rs.getString("food_type"),


                        rs.getInt("quantity"),


                        rs.getString("city"),


                        rs.getString("status"),


                        rs.getTimestamp("expiry_time")


                    }

                );

            }


        }
        catch(Exception e) {


            e.printStackTrace();

        }


        table = new JTable(model);


        add(
            new JScrollPane(table),
            BorderLayout.CENTER
        );


        setVisible(true);

    }

}