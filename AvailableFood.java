package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
import dao.RequestDAO;

import dao.FoodDAO;


public class AvailableFood extends JFrame implements ActionListener {


    JTable table;

    DefaultTableModel model;
    
    JLabel foodIdLabel;

    JTextField foodIdField;

    JButton requestBtn;


    public AvailableFood() {


        setTitle("Available Food");
        setLayout(new BorderLayout());

        setSize(850, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        model = new DefaultTableModel();


        model.addColumn("Food ID");

        model.addColumn("Food Name");

        model.addColumn("Quantity");

        model.addColumn("Unit");

        model.addColumn("City");

        model.addColumn("Expiry");

        model.addColumn("Status");


        FoodDAO dao = new FoodDAO();


        ResultSet rs = dao.getAvailableFood();


        try {


            while(rs.next()) {


                model.addRow(new Object[] {


                    rs.getInt("food_id"),

                    rs.getString("food_name"),

                    rs.getInt("quantity"),

                    rs.getString("unit"),

                    rs.getString("city"),

                    rs.getString("expiry_time"),

                    rs.getString("status")

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
        JPanel panel = new JPanel();

        foodIdLabel = new JLabel("Enter Food ID:");

        foodIdField = new JTextField(10);

        requestBtn = new JButton("Send Request");


        panel.add(foodIdLabel);

        panel.add(foodIdField);

        panel.add(requestBtn);


        add(panel, BorderLayout.SOUTH);


        requestBtn.addActionListener(this);

        setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == requestBtn) {

            try {

                int foodId =
                    Integer.parseInt(foodIdField.getText());

                // Temporary Organization ID
                int orgId = 1;


                RequestDAO dao =
                    new RequestDAO();


                boolean result =
                    dao.sendRequest(foodId, orgId);


                if(result) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Request Sent Successfully!"
                    );

                }
                else {

                    JOptionPane.showMessageDialog(
                        this,
                        "Request Failed!"
                    );

                }

            }
            catch(Exception ex) {


                JOptionPane.showMessageDialog(
                    this,
                    "Enter valid Food ID"
                );

            }

        }

    }

}