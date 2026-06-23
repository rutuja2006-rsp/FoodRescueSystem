package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

import dao.RequestDAO;


public class MyCollectionRequests extends JFrame {


    JTable table;

    DefaultTableModel model;


    public MyCollectionRequests() {


        setTitle("My Collection Requests");

        setSize(700, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        model = new DefaultTableModel();


        model.addColumn("Food ID");

        model.addColumn("Food Name");

        model.addColumn("Request Status");


        // Temporary Organization ID
        int orgId = 1;


        RequestDAO dao = new RequestDAO();


        ResultSet rs =
                dao.getOrganizationRequests(orgId);


        try {


            while(rs.next()) {


                model.addRow(new Object[] {


                    rs.getInt("food_id"),

                    rs.getString("food_name"),

                    rs.getString("status")


                });

            }


        }
        catch(Exception e) {


            e.printStackTrace();

        }



        table = new JTable(model);


        add(new JScrollPane(table));


        setVisible(true);

    }

}