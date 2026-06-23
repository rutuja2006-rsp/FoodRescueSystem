package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import dao.FoodDAO;
import dao.RequestDAO;


public class MarkCollect extends JFrame implements ActionListener {


    JTable table;

    DefaultTableModel model;


    JLabel foodLabel;


    JTextField foodField;


    JButton collectBtn;


    public MarkCollect() {


        setTitle("Mark Food Collected");


        setSize(800, 450);


        setLayout(new BorderLayout());


        setLocationRelativeTo(null);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        model = new DefaultTableModel();


        model.addColumn("Food ID");

        model.addColumn("Food Name");

        model.addColumn("Status");


        // Temporary Organization ID
        int orgId = 1;


        RequestDAO dao =
                new RequestDAO();


        ResultSet rs =
                dao.getApprovedFoods(orgId);


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


        add(new JScrollPane(table),
                BorderLayout.CENTER);



        JPanel panel = new JPanel();


        foodLabel =
                new JLabel("Food ID");


        foodField =
                new JTextField(5);


        collectBtn =
                new JButton("Collect Food");


        panel.add(foodLabel);


        panel.add(foodField);


        panel.add(collectBtn);


        add(panel, BorderLayout.SOUTH);


        collectBtn.addActionListener(this);


        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == collectBtn) {

            try {

                int foodId = Integer.parseInt(
                        foodField.getText()
                );


                FoodDAO dao = new FoodDAO();


                boolean result =
                        dao.markCollected(foodId);


                if(result) {


                    JOptionPane.showMessageDialog(
                            this,
                            "Food Collected Successfully!"
                    );


                    dispose();


                    new MarkCollect();


                }
                else {


                    JOptionPane.showMessageDialog(
                            this,
                            "Collection Failed!"
                    );

                }

            }
            catch(Exception ex) {


                JOptionPane.showMessageDialog(
                        this,
                        "Enter Valid Food ID"
                );

            }

        }
    }

    }