package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import dao.RequestDAO;


public class ViewRequests extends JFrame implements ActionListener {


    JTable table;

    DefaultTableModel model;


    JLabel requestLabel, foodLabel;


    JTextField requestField, foodField;


    JButton acceptBtn, rejectBtn;


    public ViewRequests() {


        setTitle("Food Requests");


        setSize(850, 500);


        setLayout(new BorderLayout());


        setLocationRelativeTo(null);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        model = new DefaultTableModel();


        model.addColumn("Request ID");


        model.addColumn("Food Name");


        model.addColumn("Organization");


        model.addColumn("Status");


        // Temporary donor ID
        int donorId = 1;


        RequestDAO dao =
                new RequestDAO();


        ResultSet rs =
                dao.getDonorRequests(donorId);



        try {


            while(rs.next()) {


                model.addRow(new Object[] {


                    rs.getInt("request_id"),


                    rs.getString("food_name"),


                    rs.getString("org_name"),


                    rs.getString("status")


                });

            }

        }

        catch(Exception e) {


            e.printStackTrace();

        }



        table = new JTable(model);


        add(new JScrollPane(table),
                BorderLayout.CENTER);



        JPanel panel = new JPanel();


        requestLabel =
                new JLabel("Request ID");


        requestField =
                new JTextField(5);


        foodLabel =
                new JLabel("Food ID");


        foodField =
                new JTextField(5);



        acceptBtn =
                new JButton("Accept");


        rejectBtn =
                new JButton("Reject");



        panel.add(requestLabel);
        panel.add(requestField);


        panel.add(foodLabel);
        panel.add(foodField);


        panel.add(acceptBtn);
        panel.add(rejectBtn);



        add(panel, BorderLayout.SOUTH);



        acceptBtn.addActionListener(this);


        rejectBtn.addActionListener(this);


        setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {


        RequestDAO dao = new RequestDAO();


        if(e.getSource() == acceptBtn) {


            try {


                int requestId =
                        Integer.parseInt(
                                requestField.getText()
                        );


                int foodId =
                        Integer.parseInt(
                                foodField.getText()
                        );


                boolean result =
                        dao.acceptRequest(
                                requestId,
                                foodId
                        );


                if(result) {


                    JOptionPane.showMessageDialog(
                            this,
                            "Request Accepted!\nFood Reserved Successfully."
                    );


                    dispose();


                    new ViewRequests();


                }

                else {


                    JOptionPane.showMessageDialog(
                            this,
                            "Failed to Accept Request."
                    );

                }

            }

            catch(Exception ex) {


                JOptionPane.showMessageDialog(
                        this,
                        "Enter valid Request ID and Food ID"
                );

            }

        }


        else if(e.getSource() == rejectBtn) {


            try {


                int requestId =
                        Integer.parseInt(
                                requestField.getText()
                        );


                boolean result =
                        dao.rejectRequest(requestId);


                if(result) {


                    JOptionPane.showMessageDialog(
                            this,
                            "Request Rejected Successfully."
                    );


                    dispose();


                    new ViewRequests();


                }

                else {


                    JOptionPane.showMessageDialog(
                            this,
                            "Failed to Reject Request."
                    );

                }

            }

            catch(Exception ex) {


                JOptionPane.showMessageDialog(
                        this,
                        "Enter valid Request ID"
                );

            }

        }

    }

}