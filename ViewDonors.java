package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

import dao.DonorDAO;

public class ViewDonors extends JFrame {


    JTable table;

    DefaultTableModel model;


    public ViewDonors() {


        setTitle("All Donors");


        setSize(700, 450);


        setLayout(new BorderLayout());


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );


        model = new DefaultTableModel();


        model.addColumn("Donor ID");

        model.addColumn("Name");

        model.addColumn("Email");

        model.addColumn("Phone");

        model.addColumn("City");


        DonorDAO dao = new DonorDAO();


        ResultSet rs =
                dao.getAllDonors();


        try {


            while(rs.next()) {


                model.addRow(
                    new Object[] {


                        rs.getInt("donor_id"),


                        rs.getString("name"),


                        rs.getString("email"),


                        rs.getString("phone"),


                        rs.getString("city")


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