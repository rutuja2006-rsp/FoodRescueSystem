package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

import dao.OrganizationDAO;

public class ViewOrganization extends JFrame {


    JTable table;

    DefaultTableModel model;


    public ViewOrganization() {


        setTitle("All Organizations");


        setSize(750, 450);


        setLayout(new BorderLayout());


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );


        model = new DefaultTableModel();


        model.addColumn("Organization ID");

        model.addColumn("Name");

        model.addColumn("Email");

        model.addColumn("Phone");

        model.addColumn("City");


        OrganizationDAO dao =
                new OrganizationDAO();


        ResultSet rs =
                dao.getAllOrganizations();


        try {


            while(rs.next()) {


                model.addRow(
                    new Object[] {


                    		rs.getInt("org_id"),

                    		rs.getString(
                    			    "org_name"
                    			),


                        rs.getString(
                            "email"
                        ),


                        rs.getString(
                            "phone"
                        ),


                        rs.getString(
                            "city"
                        )


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