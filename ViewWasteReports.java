package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

import dao.WasteDAO;

public class ViewWasteReports extends JFrame {


    JTable table;

    DefaultTableModel model;


    public ViewWasteReports() {


        setTitle("Waste Reports");


        setSize(900, 450);


        setLayout(new BorderLayout());


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );


        model = new DefaultTableModel();


        model.addColumn("Waste ID");

        model.addColumn("Food ID");

        model.addColumn("Quantity");

        model.addColumn("Reason");

        model.addColumn("Date");


        WasteDAO dao =
                new WasteDAO();


        ResultSet rs =
                dao.getAllWasteRecords();


        try {


            while(rs.next()) {


                model.addRow(
                    new Object[] {


                        rs.getInt(
                            "waste_id"
                        ),


                        rs.getInt(
                            "food_id"
                        ),


                        rs.getString("waste_quantity"),


                        rs.getString(
                            "reason"
                        ),


                        rs.getTimestamp(
                            "waste_date"
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